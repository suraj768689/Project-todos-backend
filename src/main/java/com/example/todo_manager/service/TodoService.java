package com.example.todo_manager.service;

import com.example.todo_manager.model.Todo;
import com.example.todo_manager.repository.ProjectRepository;
import com.example.todo_manager.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Todo addTodoToProject(Long projectId, Todo todo) {
        todo.setProject(projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found")));
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosByProjectId(Long projectId) {
        return todoRepository.findByProjectId(projectId);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo updateTodoStatus(Long id, Boolean status) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setStatus(status);
        todo.setUpdatedDate(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    public Todo updateTodoDetails(Long id, Todo updatedTodo) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setDescription(updatedTodo.getDescription());
        todo.setStatus(updatedTodo.getStatus());
        todo.setUpdatedDate(LocalDateTime.now());
        return todoRepository.save(todo);
    }
}

