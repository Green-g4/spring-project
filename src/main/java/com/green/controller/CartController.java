package com.green.controller;

import com.green.mapper.MemberMapper;
import com.green.service.CartService;
import com.green.service.EventService;
import com.green.service.MemberService;
import com.green.vo.CartVO;
import com.green.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j
public class CartController {
    @Setter(onMethod_ = @Autowired)
    CartService cartService;
    @Setter(onMethod_ = @Autowired)
    MemberService mapper;

    @PostMapping("/cart/add")
    @ResponseBody
    public String addCartPOST(CartVO cart, HttpServletRequest request) {
        // 로그인 체크
        HttpSession session = request.getSession();
        if (session.getAttribute("signedUser") == null) {
            return "5";
        }
        // 카트 등록

        int result = cartService.addCart(cart);

        return result + "";
    }

    @GetMapping("/cart/cart")
    public String cartPageGET(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("signedUser") != null) {
            String id = mapper.getId(session.getAttribute("signedUser").toString());
            log.info("id=============              " + cartService.getCartList(id));
            model.addAttribute("cartInfo", cartService.getCartList(id));
            model.addAttribute("member", session.getAttribute("signedUser").toString());
            return "/cart/cart"; // 로그인 페이지로 이동
        }
        return "redirect:/main/main"; // 로그인 페이지로 이동
    }

    /* 장바구니 수량 수정 */
    @PostMapping("/cart/update")
    public String updateCartPOST(CartVO cart) {

        log.info("===========================" + "\n" + cart);
        cartService.modifyCount(cart);

        return "redirect:/cart/cart";

    }

    /* 장바구니 수량 수정 */
    @PostMapping("/cart/delete")
    public String deleteCartPOST(CartVO cart) {

        cartService.deleteCart(cart.getCartId());

        return "redirect:/cart/cart";

    }
}