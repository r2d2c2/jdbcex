package org.zerock.jdbcex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.zerock.jdbcex.dto.MemberDTO;
import org.zerock.jdbcex.service.MemberService;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        try{
            MemberDTO memberDTO = MemberService.instance.Login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);//세션으로 저장
            resp.sendRedirect("/todo/list");
        }catch (Exception e){
            //dto가 널이면 실행
            resp.sendRedirect("/login?result=error");
        }
//        String str=mid+mpw;
//        HttpSession session=req.getSession();
//        session.setAttribute("loginInfo", str);//세션 저장
//        resp.sendRedirect("/todo/list");
    }
}
