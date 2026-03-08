package org.edu.tasknest;

import org.edu.tasknest.dto.TaskRequestDTO;
import org.edu.tasknest.enums.TaskStatus;
import org.edu.tasknest.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskNestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskNestApplication.class, args);
    }

    @Bean
    CommandLineRunner run(TaskService taskService){
        return args -> {

            TaskRequestDTO task = TaskRequestDTO.builder()
                    .title("Learn Spring Boot")
                    .description("Complete service layer")
                    .status(TaskStatus.PENDING)
                    .build();

            taskService.createTask(task);

            System.out.println("All tasks : " + taskService.getAllTasks());
        };
    }
}


