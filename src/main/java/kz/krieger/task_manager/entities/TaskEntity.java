package kz.krieger.task_manager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "task_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 36, message = "Title must be lower than 36 characters!")
    private String title;
    @Size(max = 150,message = "Description of the task must be lower than 150 characters!")
    private String description;

    private LocalDateTime creationDate;
    private boolean isDone = false;
    private LocalDateTime endDate;
}
