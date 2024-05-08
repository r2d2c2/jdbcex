package org.zerock.jdbcex.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.domain.TodoVO;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoDAOTest {
    TodoDAO todoDAO;
    @BeforeEach//초기화(Test코드 동작전에 실행)
    public void ready(){
        todoDAO = new TodoDAO();
    }
    @Test
    void testInsert() {
        TodoVO myvo=TodoVO.builder().title("빌드 테스트").dueDate(LocalDate.now()).finished(true).build();
        System.out.println(myvo);
        todoDAO.setData(myvo);
        //todoDAO.setData(new TodoVO(1L,"test", LocalDate.now(),true));

    }
    @Test
    void getTime() {
        System.out.println("@@@@@@@@@@@@@"+todoDAO.getTime());
        System.out.println(todoDAO.toString());
        assertNotNull(todoDAO.getTime());
    }
    @Test
    void getSelect() throws Exception {
        TodoVO todoVO = todoDAO.selectData(26L);
        System.out.println(todoVO.toString());
    }

    @Test
    public void testLise() throws Exception {
        List<TodoVO> todoVOS = todoDAO.selectAll();
        todoVOS.forEach(System.out::println);
        System.out.println();
        todoVOS.forEach(o-> System.out.println(o));
    }
    @Test
    void testUpdate() throws Exception {
        TodoVO vo = TodoVO.builder()
                .tno(3L)
                .dueDate(LocalDate.now())
                .title("변경")
                .finished(false)
                .build();
        todoDAO.updateData(vo);
        System.out.println("vo = " + vo);
    }
    @Test
    public void testDelete() throws Exception {
        Long id=10L;
        //Assertions.assertNotNull(todoDAO.selectData(id));
        todoDAO.deleteData(id);
        Assertions.assertNull(todoDAO.selectData(id));
    }

}