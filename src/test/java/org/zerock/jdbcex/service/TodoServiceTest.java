package org.zerock.jdbcex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dto.TodoDTO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {
    private TodoService todoService;
    @BeforeEach
    void ready() {
        todoService=TodoService.instance;
    }

    @Test
    void register() throws Exception {
        TodoDTO dto=TodoDTO.builder()
                .title("title")
                .dueDate(LocalDate.now())
                .build();
        todoService.register(dto);
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}