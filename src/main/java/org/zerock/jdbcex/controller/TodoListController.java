package org.zerock.jdbcex.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;


import java.io.IOException;
import java.util.List;
@Slf4j
@WebServlet(urlPatterns = "/todo/list",name = "todoListController")
public class TodoListController extends HttpServlet {
    @SneakyThrows//데이터 예외처리
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.error("todo List....");
        System.out.println("todo List....");
        ServletContext servletContext = req.getServletContext();
        //이벤트 리스너에서 get
        log.error("appName = {}", servletContext.getAttribute("appName"));
        System.out.println("appName = " + servletContext.getAttribute("appName"));

        List<TodoDTO> dtoList = TodoService.instance.listAll();
        System.out.println(this);
        System.out.println(Thread.currentThread().getName());
        req.setAttribute("list", dtoList);
        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        //req.getRequestDispatcher("/todo/list.jsp").include(req, resp);//포함 시키기 include
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        session.invalidate();
        log.trace("logout ok!");
        System.out.println("logout ok");
        String  mid = (String) req.getAttribute("mid");
        String  mpw = (String) req.getAttribute("mpw");


        /*if(session.getAttribute(mid)==mid&&session.getAttribute(mpw)==mpw) {
            session.setAttribute("loginInfo",null);
        }*/
    }

    @Override
    public void destroy() {
        super.destroy();//끝날때
    }
}
