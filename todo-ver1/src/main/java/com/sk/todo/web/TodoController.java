package com.sk.todo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    @PostMapping("/todo")
    public ResponseEntity<ToDo> todo(TodoRequest request) {
        var saveTodo = todoService.save(mapper.apply(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTodo);
    }

    @GetMapping("/todo")
    public List<ToDo> all(){
        return todoService.retrieveAll();
    }
}