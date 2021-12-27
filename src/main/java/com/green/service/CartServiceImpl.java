package com.green.service;

import com.green.mapper.CartMapper;
import com.green.vo.CartVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class CartServiceImpl implements CartService{

    @Setter(onMethod_=@Autowired)
    private CartMapper cartMapper;

    @Override
    public int addCart(CartVO cart) {
        // 장바구니 데이터 체크
        CartVO checkCart = cartMapper.checkCart(cart);

        if(checkCart != null) {
            return 2;
        }

        // 장바구니 등록 & 에러 시 0반환
        try {
            return cartMapper.addCart(cart);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<CartVO> getCartList(String memberId) {
        List<CartVO> cart = cartMapper.getCart(memberId);

        for(CartVO dto : cart) {
            dto.initSaleTotal();

        }

        return cart;
    }

    @Override
    public int modifyCount(CartVO cart) {

        return cartMapper.modifyCount(cart);
    }

    @Override
    public int deleteCart(int cartId) {

        return cartMapper.deleteCart(cartId);
    }
}
