package com.sk.todo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    @PostMapping("/todo")
    public ResponseEntity<ToDo> todo(TodoRequest request) {
        var saveTodo = todoService.save(mapper.apply(request));
        //TODO, MDN Web Docs : Created 상태 코드는 새로 생성된 자원의 주소를 함께 반환해야 한다.
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveTodo.getId()).toUri();
        return ResponseEntity.created(uri).body(saveTodo);
    }

    @GetMapping("/todo")
    public List<ToDo> all(){
        return todoService.retrieveAll();
    }

    @GetMapping("/todo/{id}")
    public ToDo retrieve(@PathVariable  long id){
        return todoService.findOne(id);
    }
}