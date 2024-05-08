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

@WebServlet(urlPatterns = "/todo/modify",name = "todoModifyC")
public class TodoModifyController extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO todoDto = TodoService.instance.get(tno);
        //예외
        if(todoDto == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"tno not found");
        }
        req.setAttribute("todoDTO", todoDto);
        req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long tno = Long.valueOf(req.getParameter("tno"));
        String title = req.getParameter("title");
        LocalDate date = LocalDate.parse(req.getParameter("dueDate"));
        System.out.println("req.getParameter(\"done\") = " + req.getParameter("done"));
        boolean done = (req.getParameter("done")==null ? false:true );
        System.out.println(new TodoDTO(tno,title,date,done));
        //TodoService.INSTANCE.update(new TodoDto(tno,title,date,done));

        boolean update= TodoService.instance.update(new TodoDTO(tno,title,date,done));
        if(update)
            resp.sendRedirect("/todo/list");//get으로
        else
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"update failed");
    }
}
