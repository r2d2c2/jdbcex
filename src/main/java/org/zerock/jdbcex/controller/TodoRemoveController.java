package org.zerock.jdbcex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.zerock.jdbcex.service.TodoService;


import java.io.IOException;

@WebServlet(urlPatterns = "/todo/delete")
public class TodoRemoveController extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));
        boolean delete = TodoService.instance.delete(tno);
        if(delete)
            resp.sendRedirect("/todo/list");
        else
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
