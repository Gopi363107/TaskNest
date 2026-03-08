package org.edu.tasknest.service;

import org.edu.tasknest.dto.TaskRequestDTO;
import org.edu.tasknest.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO dto);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO getTaskById(Long id);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO dto);

    void deleteTask(Long id);
}