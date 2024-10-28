package com.example.todo_manager.service;

import com.example.todo_manager.model.Project;
import com.example.todo_manager.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Service
public class GistService {

    private final String GITHUB_TOKEN = "<YOUR_GITHUB_TOKEN>";

    public String exportProjectAsGist(Project project) {
        StringBuilder content = new StringBuilder();
        content.append("# ").append(project.getTitle()).append("\n");
        content.append("Summary: ").append(project.getTodos().stream().filter(Todo::getStatus).count())
                .append("/").append(project.getTodos().size()).append(" completed.\n\n");

        content.append("## Pending Tasks\n");
        project.getTodos().stream()
                .filter(todo -> !todo.getStatus())
                .forEach(todo -> content.append("- [ ] ").append(todo.getDescription()).append("\n"));

        content.append("## Completed Tasks\n");
        project.getTodos().stream()
                .filter(Todo::getStatus)
                .forEach(todo -> content.append("- [x] ").append(todo.getDescription()).append("\n"));

        Map<String, Object> gistData = new HashMap<>();
        gistData.put("description", "Project summary gist");
        gistData.put("public", false);
        gistData.put("files", Map.of(project.getTitle() + ".md", Map.of("content", content.toString())));

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(GITHUB_TOKEN);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(gistData, headers);

        ResponseEntity<String> response = restTemplate.exchange("https://api.github.com/gists", HttpMethod.POST, entity, String.class);
        return response.getBody(); // Replace with extracting URL if necessary
    }
}

