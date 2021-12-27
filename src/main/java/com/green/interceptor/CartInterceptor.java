package com.green.interceptor;


import com.green.vo.MemberVO;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Log4j
public class CartInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        log.info(session.getAttribute("signedUser"));


        if(session.getAttribute("signedUser") == null) {
            response.sendRedirect("/main/main");
            return false;
        } else {
            return true;
        }
    }
}
