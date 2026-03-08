package org.edu.tasknest.dto;

import lombok.*;
import org.edu.tasknest.enums.TaskStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequestDTO {
    private String title;
    private String description;
    private TaskStatus status;
}
