package com.sk.todo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    @PostMapping
    public ResponseEntity<Todo> todo(TodoRequest request) {
        var saveTodo = todoService.save(mapper.apply(request));
        //TODO, MDN Web Docs : Created 상태 코드는 새로 생성된 자원의 주소를 함께 반환해야 한다.
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveTodo.getId()).toUri();
        return ResponseEntity.created(uri).body(saveTodo);
    }

    @GetMapping
    public List<Todo> all(){
        return todoService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Todo retrieve(@PathVariable  long id){
        return todoService.findOne(id);
    }
}