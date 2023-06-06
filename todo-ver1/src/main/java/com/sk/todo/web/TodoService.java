package com.sk.todo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    private final List<Todo> list = new ArrayList<>();
    private final AtomicLong count = new AtomicLong(0L);

    @PostConstruct
    private void init(){
        todoRepository.save(new Todo(count.getAndIncrement(), "test1", LocalDateTime.now(), false ));
        todoRepository.save(new Todo(count.getAndIncrement(), "test2", LocalDateTime.now(), false ));
        todoRepository.save(new Todo(count.getAndIncrement(), "test3", LocalDateTime.now(), false ));
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> retrieveAll(){
        return todoRepository.findAll();
    }

    public Todo findOne(long id) {
        return todoRepository.findById(id).orElse(null);
    }
}