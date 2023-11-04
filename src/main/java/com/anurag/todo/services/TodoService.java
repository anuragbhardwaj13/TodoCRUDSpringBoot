package com.anurag.todo.services;

import com.anurag.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();

    Todo getTodoById(Long id);

    Todo insert(Todo todo);

    void update(Long id,Todo todo);

    void delete(Long id);
}
