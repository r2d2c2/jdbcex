package org.zerock.jdbcex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;


import java.io.IOException;
import java.time.LocalDate;
@Log4j2
@WebServlet(name = "todoReadController",value = "/todo/read")
public class TodoReadController extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO dto = TodoService.instance.get(tno);
        req.setAttribute("dto",dto);
        
        //쿠기 생성 "쿠키이름" (쿠키는 키와 값으로 저장되어있다)
        Cookie viewTodoCookie=findCookie(req.getCookies(),"viewTodo");
        String value = viewTodoCookie.getValue();

        boolean exist=false;
        if(value !=null&&value.indexOf(tno+"-")>=0){
            //이미 같은 쿠키가 있다면
            exist=true;
        }
        if(!exist){//처음 와서 같은 쿠키가 없다면
            value+=tno+"-";
            viewTodoCookie.setValue(value);//쿠키 설정
            viewTodoCookie.setPath("/");
            viewTodoCookie.setMaxAge(60*60*24);
            resp.addCookie(viewTodoCookie);//쿠키 저장
        }

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req,resp);
        //.jsp로 보네기
    }

    private Cookie findCookie(Cookie[] cookies, String viewTodo) {
        Cookie resultCookie=null;
        if(cookies!=null&&cookies.length>0) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(viewTodo)) {
                    resultCookie=cookie;
                }
            }
        }
        if(resultCookie==null) {
            resultCookie=new Cookie(viewTodo,"");
            //viewTodo라는 이름의 쿠키 생성
            resultCookie.setPath("/");//쿠키의 범위(쿠키 사용 범위)
            resultCookie.setMaxAge(60*60*24);//기본 초단위
            //60>>분 60*60>>시 60*60*24 하루(24시간)
        }
        return resultCookie;
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.valueOf(req.getParameter("tno"));
        String title = req.getParameter("title");
        LocalDate date = LocalDate.parse(req.getParameter("dueDate"));
        boolean done = Boolean.parseBoolean(req.getParameter("done"));
        System.out.println(new TodoDTO(tno,title,date,done));
        TodoService.instance.update(new TodoDTO(tno,title,date,done));
        resp.sendRedirect("/todo/list");//get으로
    }

}
