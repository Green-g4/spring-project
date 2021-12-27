package com.green.mapper;

import com.green.vo.*;

public interface OrdersMapper {
    /* 주문 상품 정보 */
    public OrderPageItemDTO getGoodsInfo(int id);

    /* 주문 상품 정보(주문 처리) */
    public OrderItemDTO getOrderInfo(int id);

    /* 주문 테이블 등록 */
    public int enrollOrder(OrderDTO ord);

    /* 주문 아이템 테이블 등록 */
    public int enrollOrderItem(OrderItemDTO orid);

    /* 주문 금액 차감 */
    public int deductMoney(MemberVO member);

    /* 주문 재고 차감 */
    public int deductStock(ProductVO product);
}
