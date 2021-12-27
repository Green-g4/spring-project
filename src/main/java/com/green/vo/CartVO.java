package com.green.vo;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class CartVO {
    private int cartId;

    private String memberId;

    private int productId;

    private int productCount;

    //book

    private String product_name;

    private int product_price;

    private int product_discount;

    // 추가
    private int salePrice;

    private int totalPrice;

    private int point;

    private int totalPoint;




    public int getPoint() {
        return point;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public int getCartId() {
        return cartId;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getProductId() {
        return productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public int getProduct_discount() {
        return product_discount;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public void setProduct_discount(int product_discount) {
        this.product_discount = product_discount;
    }


    public void initSaleTotal() {
        this.salePrice = (int) (this.product_price * (1-(this.product_discount)/100));
        this.totalPrice = this.salePrice*this.productCount;
        this.point = (int)(Math.floor(this.salePrice*0.05));
        this.totalPoint =this.point * this.productCount;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cartId=" + cartId +
                ", memberId='" + memberId + '\'' +
                ", productId=" + productId +
                ", productCount=" + productCount +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_discount=" + product_discount +
                ", salePrice=" + salePrice +
                ", totalPrice=" + totalPrice +
                ", point=" + point +
                ", totalPoint=" + totalPoint +
                '}';
    }
}
