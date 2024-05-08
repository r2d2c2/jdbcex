package org.zerock.jdbcex.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
@Log4j2
public class UTF8Filter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //servletRequest.setCharacterEncoding("UTF-8");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req= (HttpServletRequest) servletRequest;

        req.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
        //모든 구역에 utf-8적용
    }
}
