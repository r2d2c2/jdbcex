package org.zerock.jdbcex.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import lombok.extern.log4j.Log4j2;

@WebListener //웹 서버 시작시 적용
@Log4j2
public class ExListener implements ServletContextListener {//전체 리스너
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.error("---- listener init ---------");//서버 시작시 실행
        ServletContext servletContext = sce.getServletContext();
        //이밴트 객체 담기
        //매개변수로 sce에 변경 값이 받는다
        servletContext.setAttribute("appName","jdbcex");
        //jdbcex는 경로
        //Attribute등록 하여 appName으로 get 가능 하다
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.error("---- listener destroyed ---------");
    }
}
