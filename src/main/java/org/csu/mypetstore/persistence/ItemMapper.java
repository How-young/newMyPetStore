package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ItemMapper {
    //更新库存数量
    void updateInventoryQuantity(Map<String, Object> param);

    //获得库存数量
    int getInventoryQuantity(String itemId);

    //通过产品获取物品
    List<Item> getItemListByProduct(String productId);

    //获取物品
    Item getItem(String itemId);
}
