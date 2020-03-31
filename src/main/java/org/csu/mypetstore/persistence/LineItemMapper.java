package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.LineItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemMapper {
    //通过订单号获取物品列表
    List<LineItem> getLineItemByOrderId(int orderId);

    //插入lineItem
    void insertLineItem(LineItem lineItem);
}
