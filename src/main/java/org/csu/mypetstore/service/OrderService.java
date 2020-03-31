package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.persistence.ItemMapper;
import org.csu.mypetstore.persistence.LineItemMapper;
import org.csu.mypetstore.persistence.OrderMapper;
import org.csu.mypetstore.persistence.SequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    @Autowired
    private LineItemMapper lineItemMapper;

    //获取下一个Id
    public int getNextId(String name){
        Sequence sequence = new Sequence(name, -1);
        sequence = sequenceMapper.getSequence(sequence);
        if (sequence == null){
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name + "sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceMapper.updateSequence(parameterObject);
        return sequence.getNextId();
    }

    @Transactional
    public void insertOrder(Order order){
        order.setOrderId(getNextId("ordernum"));
        orderMapper.insertOrder(order);
        orderMapper.insertOrderStatus(order);
        for (int i=0; i<order.getLineItems().size(); i++){
            LineItem lineItem = order.getLineItems().get(i);
            String itemId = lineItem.getItemId();
            Integer increment = new Integer(lineItem.getQuantity());
            Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("itemId", itemId);
            param.put("increment", increment);
            itemMapper.updateInventoryQuantity(param);

//            LineItem lineItem = order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemMapper.insertLineItem(lineItem);
        }
    }

    @Transactional
    public Order getOrder(int orderId){
        Order order = orderMapper.getOrder(orderId);
        order.setLineItems(lineItemMapper.getLineItemByOrderId(orderId));

        for (int i=0; i<order.getLineItems().size(); i++){
            LineItem lineItem = order.getLineItems().get(i);
            Item item = itemMapper.getItem(lineItem.getItemId());
            item.setQuantity(itemMapper.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }
        return order;
    }

    @Transactional
    public List<Order> getOrderByUsername(String username){
        return orderMapper.getOrderByUsername(username);
    }
}
