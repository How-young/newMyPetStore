package org.csu.mypetstore.domain;

import java.math.BigDecimal;
import java.util.*;

public class Cart {
    private final Map<String, CartItem> itemMap= Collections.synchronizedMap(new HashMap<String, CartItem>());
    private final List<CartItem> itemList = new ArrayList<CartItem>();

    //遍历元素，生成列表
    public Iterator<CartItem> getCartItems(){
        return itemList.iterator();
    }

    //获取购物车物品
    public List<CartItem> getCartItemList(){
        return itemList;
    }

    //获得物品数量
    public int getNumberOfItems(){
        return itemList.size();
    }

    //获得所有商品
    public Iterator<CartItem> getAllCartItems(){
        return itemList.iterator();
    }

    //是否物品Id
    public boolean containsItemId(String itemId){
        return itemMap.containsKey(itemId);
    }

    //添加商品
    public void addItem(Item item, boolean isInStock){
        CartItem cartItem = itemMap.get(item.getItemId());
        if (cartItem == null){
            cartItem = new CartItem();
            cartItem.setItem(item);
            cartItem.setQuantity(0);
            cartItem.setInStock(isInStock);
            itemMap.put(item.getItemId(), cartItem);
            itemList.add(cartItem);
        }
        cartItem.increaseQuantity();
    }

    //移除商品
    public Item removeItem(String itemId){
        CartItem cartItem = itemMap.remove(itemId);
        if (cartItem == null){
            return null;
        } else {
            itemList.remove(cartItem);
            return cartItem.getItem();
        }
    }

    //通过Id增加数量
    public void increaseItem(String itemId){
        CartItem cartItem = itemMap.get(itemId);
        cartItem.increaseQuantity();
    }

    //设置商品数量
    public void setQuantity(String itemId,int quantity){
        CartItem cartItem = itemMap.get(itemId);
        cartItem.setQuantity(quantity);
    }

    //获得总价钱
    public BigDecimal getSubTotal(){
        BigDecimal total = new BigDecimal("0");
        Iterator<CartItem> items = getAllCartItems();
        while(items.hasNext()){
            CartItem cartItem = items.next();
            Item item = cartItem.getItem();
            BigDecimal listPrice = item.getListPrice();
            BigDecimal quantity = new BigDecimal(String.valueOf(cartItem.getQuantity()));
            total = total.add(listPrice.multiply(quantity));
        }
        return total;
    }
}
