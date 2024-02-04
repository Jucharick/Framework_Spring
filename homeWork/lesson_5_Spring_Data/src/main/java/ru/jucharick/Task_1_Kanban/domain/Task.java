package ru.jucharick.Task_1_Kanban.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    //region Поля
    /**
     * ID of the task
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * the title of the task
     */
    @Column(nullable = false)
    private String title;

    /**
     * the description of the task
     */
    @Column(nullable = false)
    private String description;

    /**
     * the status of the task
     * assigned
     * in_progress
     * resolved
     * reopened
     * closed
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /**
     * who requested the task (ID of the user)
     */
    @Column(nullable = true)
    private int requestedBy;

    /**
     * who assigned the task (ID of the user)
     */
    @Column(nullable = true)
    private int assignedBy;

    /**
     * who was assigned the task (ID of the user)
     */
    @Column(nullable = true)
    private int assigneeID;

    /**
     * date the task was created or updated
     */
    @Column(nullable = false)
    private LocalDateTime dateTime;
    //endregion
}
