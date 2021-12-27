package com.green.vo;

import lombok.ToString;

@ToString
public class OrderItemDTO {

    /* 주문 번호 */
    private String orderId;

    /* 상품 번호 */
    private int Product_Id;

    /* 주문 수량 */
    private int Product_Count;

    /* vam_orderItem 기본키 */
    private int orderItemId;

    /* 상품 한 개 가격 */
    private int Product_Price;

    /* 상품 할인 율 */
    private double Product_Discount;

    /* 상품 한개 구매 시 획득 포인트 */
    private int savePoint;

    /* DB테이블 존재 하지 않는 데이터 */

    /* 할인 적용된 가격 */
    private int salePrice;

    /* 총 가격(할인 적용된 가격 * 주문 수량) */
    private int totalPrice;

    /* 총 획득 포인트(상품 한개 구매 시 획득 포인트 * 수량) */
    private int totalSavePoint;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(int Product_Id) {
        this.Product_Id = Product_Id;
    }

    public int getProduct_Count() {
        return Product_Count;
    }

    public void setProduct_Count(int Product_Count) {
        this.Product_Count = Product_Count;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Product_Price(int Product_Price) {
        this.Product_Price = Product_Price;
    }

    public double getProduct_Discount() {
        return Product_Discount;
    }

    public void setProduct_Discount(double Product_Discount) {
        this.Product_Discount = Product_Discount;
    }

    public int getSavePoint() {
        return savePoint;
    }

    public void setSavePoint(int savePoint) {
        this.savePoint = savePoint;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalSavePoint() {
        return totalSavePoint;
    }

    public void setTotalSavePoint(int totalSavePoint) {
        this.totalSavePoint = totalSavePoint;
    }

    public void initSaleTotal() {
        this.salePrice = (int) (this.Product_Price * (1-this.Product_Discount));
        this.totalPrice = this.salePrice*this.Product_Count;
        this.savePoint = (int)(Math.floor(this.salePrice*0.05));
        this.totalSavePoint =this.savePoint * this.Product_Count;
    }
}
