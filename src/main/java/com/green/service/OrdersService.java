package com.green.service;

import com.green.vo.OrderDTO;
import com.green.vo.OrderPageItemDTO;

import java.util.List;

public interface OrdersService {
    /* 주문 정보 */
    public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders);

    /* 주문 */
    public void order(OrderDTO orw);
}
