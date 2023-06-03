package com.sk.todo.web;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    private Long id;
    private String description;
    private LocalDateTime dueDate;
    private boolean status;

    public void id(long id) {
        this.id = id;
    }
}
