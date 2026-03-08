package org.edu.tasknest.entity;
import org.edu.tasknest.enums.TaskStatus;
import java.time.LocalDateTime;
import lombok.ToString;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tasks")
@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 200)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(nullable = false , updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}


