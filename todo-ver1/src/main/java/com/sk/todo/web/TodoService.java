package com.sk.todo.web;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {

    private final List<ToDo> list = new ArrayList<>();
    private final AtomicLong count = new AtomicLong(0L);

    @PostConstruct
    private void init(){
        list.add(new ToDo(count.getAndIncrement(), "test1", LocalDateTime.now(), false ));
        list.add(new ToDo(count.getAndIncrement(),"test2", LocalDateTime.now(), false ));
        list.add(new ToDo(count.getAndIncrement(),"test3", LocalDateTime.now(), false ));
    }

    public ToDo save(ToDo todo) {
        todo.id(count.getAndIncrement());
        list.add(todo);
        return todo;
    }

    public List<ToDo> retrieveAll(){
        return list;
    }
}