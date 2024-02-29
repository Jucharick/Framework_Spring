package ru.jucharick.Tasks.observer;

import org.springframework.context.ApplicationEvent;
import ru.jucharick.Tasks.domain.Task;

public class TaskUpdatedEvent extends ApplicationEvent {
    private Task task;
    public TaskUpdatedEvent(Object source, Task task) {
        super(source);
        this.task = task;
    }
}
