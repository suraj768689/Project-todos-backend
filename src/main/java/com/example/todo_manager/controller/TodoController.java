package com.example.todo_manager.controller;

import com.example.todo_manager.model.Todo;
import com.example.todo_manager.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/project/{projectId}")
    public ResponseEntity<Todo> addTodoToProject(@PathVariable Long projectId, @RequestBody Todo todo) {
        try {
            Todo createdTodo = todoService.addTodoToProject(projectId, todo);
            return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Todo>> getTodosByProjectId(@PathVariable Long projectId) {
        List<Todo> todos = todoService.getTodosByProjectId(projectId);
        if (todos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .map(todo -> new ResponseEntity<>(todo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Todo> updateTodoStatus(@PathVariable Long id, @RequestParam Boolean status) {
        try {
            Todo updatedTodo = todoService.updateTodoStatus(id, status);
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodoDetails(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        try {
            Todo todo = todoService.updateTodoDetails(id, updatedTodo);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

