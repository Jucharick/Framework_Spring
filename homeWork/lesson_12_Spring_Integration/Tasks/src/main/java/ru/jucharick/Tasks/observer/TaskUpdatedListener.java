package ru.jucharick.Tasks.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.jucharick.Tasks.domain.Task;

@Component
public class TaskUpdatedListener implements ApplicationListener<TaskUpdatedEvent> {
    @Override
    public void onApplicationEvent(TaskUpdatedEvent event) {
        // Сделать что-то с event.getTask()

    }
}
