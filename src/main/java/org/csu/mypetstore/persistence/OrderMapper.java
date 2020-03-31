package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    //通过用户名获得订单
    List<Order> getOrderByUsername(String username);

    //通过账单ID获取账单
    Order getOrder(int orderId);

    //插入订单
    void insertOrder(Order order);

    //插入账单状态
    void insertOrderStatus(Order order);
}
