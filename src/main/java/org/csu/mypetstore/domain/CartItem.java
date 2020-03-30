package org.csu.mypetstore.domain;

import java.math.BigDecimal;

public class CartItem {
    private Item item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        calculate();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculate();
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getTotal() {
        return total;
    }

    //增加数量
    public void increaseQuantity(){
        quantity++;
        calculate();
    }

    //计算总价
    public void calculate(){
        if (item != null && item.getListPrice() != null){
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
    }
}
