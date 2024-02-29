package ru.jucharick.Tasks.domain;

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

    //region Методы

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(int requestedBy) {
        this.requestedBy = requestedBy;
    }

    public int getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(int assignedBy) {
        this.assignedBy = assignedBy;
    }

    public int getAssigneeID() {
        return assigneeID;
    }

    public void setAssigneeID(int assigneeID) {
        this.assigneeID = assigneeID;
    }
    //endregion
}
