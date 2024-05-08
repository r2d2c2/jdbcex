package org.zerock.jdbcex.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebServlet(urlPatterns = {"/todo/*"})//todo 하위에 모든 경로에 적용 {}으로 하면 여러경로 지정가능
public class LoginCheckFilter implements Filter {
    @Override //http가 아닌 그냥 서블릿 리퀘스트를 받는다
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("login check filter");
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //사용을 위해 http서블릿으로 다운 케스팅
        HttpServletRequest req= (HttpServletRequest) servletRequest;

        HttpSession session = req.getSession();
        if(session.getAttribute("loginInfo") == null) {//로그인 정보가 없으면
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
