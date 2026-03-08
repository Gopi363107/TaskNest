package org.edu.tasknest.service;

import lombok.RequiredArgsConstructor;
import org.edu.tasknest.dto.TaskRequestDTO;
import org.edu.tasknest.dto.TaskResponseDTO;
import org.edu.tasknest.entity.Task;
import org.edu.tasknest.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    // CREATE TASK
    @Override
    public TaskResponseDTO createTask(TaskRequestDTO dto){

        Task task = Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();

        Task savedTask = taskRepository.save(task);

        return mapToResponseDTO(savedTask);
    }

    // GET ALL TASKS
    @Override
    public List<TaskResponseDTO> getAllTasks(){

        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // GET TASK BY ID
    @Override
    public TaskResponseDTO getTaskById(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        return mapToResponseDTO(task);
    }

    // UPDATE TASK
    @Override
    public TaskResponseDTO updateTask(Long id , TaskRequestDTO dto){

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        existingTask.setTitle(dto.getTitle());
        existingTask.setDescription(dto.getDescription());
        existingTask.setStatus(dto.getStatus());

        Task updatedTask = taskRepository.save(existingTask);

        return mapToResponseDTO(updatedTask);
    }

    // DELETE TASK
    @Override
    public void deleteTask(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        taskRepository.delete(task);
    }

    // ENTITY → DTO MAPPING METHOD
    private TaskResponseDTO mapToResponseDTO(Task task){

        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }
}
