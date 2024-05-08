package org.zerock.jdbcex.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class LoginListener implements HttpSessionAttributeListener {//세션에만 사용되는 리스너

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {//세션 추가시 실행
        String name=event.getName();//세션의 이름과
        Object obj = event.getValue();//세션의 값을 받고

        if(name.equals("loginInfo")){
            System.out.println(obj);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {//세션 제거시
        HttpSessionAttributeListener.super.attributeRemoved(event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {//세션에 변경이 생기면
        HttpSessionAttributeListener.super.attributeReplaced(event);
    }
}
