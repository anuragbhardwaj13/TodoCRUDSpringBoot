package com.anurag.todo.services;

import com.anurag.todo.model.Todo;
import com.anurag.todo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoServicesImpl implements TodoService {
    TodoRepository todoRepository;
    public TodoServicesImpl(TodoRepository todoRepository){
        this.todoRepository=todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todosList=new ArrayList<>();
        todoRepository.findAll().forEach(todosList::add);
        return todosList;
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo insert(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void update(Long id, Todo todo) {
Todo todoFromDB=todoRepository.findById(id).get();
todoFromDB.setTodoStatus(todo.getTodoStatus());
todoFromDB.setTitle(todo.getTitle());
todoRepository.save(todoFromDB);

    }

    @Override
    public void delete(Long id) {
todoRepository.deleteById(id);
    }
}
