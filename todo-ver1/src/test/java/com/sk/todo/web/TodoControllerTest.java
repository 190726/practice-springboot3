package com.sk.todo.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoControllerTest {

    TodoController todoController = new TodoController();

    @Test
    void todoControllerTest(){
        final var todo = todoController.todo();
        Assertions.assertThat(todo).isEqualTo("todo");
    }
}