package org.edu.tasknest.controller;

import lombok.RequiredArgsConstructor;
import org.edu.tasknest.dto.TaskRequestDTO;
import org.edu.tasknest.dto.TaskResponseDTO;
import org.edu.tasknest.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // CREATE TASK
    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO dto){
        return taskService.createTask(dto);
    }

    // GET ALL TASKS
    @GetMapping
    public List<TaskResponseDTO> getAllTasks(){
        return taskService.getAllTasks();
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id,
                                      @RequestBody TaskRequestDTO dto){
        return taskService.updateTask(id, dto);
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}