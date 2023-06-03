package com.sk.todo.web;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class TodoMapper implements Function<TodoRequest, ToDo> {
    @Override
    public ToDo apply(TodoRequest o) {
        return ToDo.builder()
                .description(o.description())
                .dueDate(LocalDateTime.now().plusWeeks(1))
                .status(false)
                .build();
    }
}