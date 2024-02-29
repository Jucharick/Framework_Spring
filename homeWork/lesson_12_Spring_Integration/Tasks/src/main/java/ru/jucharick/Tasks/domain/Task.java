package ru.jucharick.Tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    //region Поля
    /**
     * ID of the task
     */
    private int id;

    /**
     * the title of the task
     */
    private String title;

    /**
     * the description of the task
     */
    private String description;

    /**
     * the status of the task
     * assigned
     * in_progress
     * resolved
     * reopened
     * closed
     */
    private String status;

    /**
     * who requested the task (ID of the user)
     */
    private int requestedBy;

    /**
     * who assigned the task (ID of the user)
     */
    private int assignedBy;

    /**
     * who was assigned the task (ID of the user)
     */
    private int assigneeID;
    //endregion
}
