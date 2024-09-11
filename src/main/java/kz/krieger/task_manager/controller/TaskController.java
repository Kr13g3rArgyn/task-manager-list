package kz.krieger.task_manager.controller;

import kz.krieger.task_manager.dto.TaskDTO;
import kz.krieger.task_manager.mapper.TaskMapper;
import kz.krieger.task_manager.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
public class TaskController {
    private TaskService taskService;

    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService,TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getTasks(){
        return ResponseEntity.ok(taskService.getTasks().stream().map(taskMapper::convertToDTO).collect(Collectors.toList()));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<List<TaskDTO>> getTaskById(@RequestBody Long id){
        return ResponseEntity.ok(taskService.getTaskById(id).stream().map(taskMapper::convertToDTO).collect(Collectors.toList()));
    }

}
