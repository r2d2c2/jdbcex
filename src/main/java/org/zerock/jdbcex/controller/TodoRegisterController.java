package org.zerock.jdbcex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;


import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/todo/register",name = "todoRegisterController")
public class TodoRegisterController extends HttpServlet {
    //회원 가입

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long tno=Long.parseLong(req.getParameter("tno"));
        String title=req.getParameter("title");
        LocalDate due=LocalDate.parse(req.getParameter("due"));
        boolean done=Boolean.parseBoolean(req.getParameter("done"));
        TodoService.instance.register(new TodoDTO(tno,title,due,done));
        //String title = req.getParameter("title");
        //TodoService.INSTANCE.addT( title);
        resp.sendRedirect("/todo/list");
    }

}
