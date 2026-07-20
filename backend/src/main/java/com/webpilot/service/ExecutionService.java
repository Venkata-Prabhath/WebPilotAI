package com.webpilot.service;

import com.webpilot.agent.DecisionEngine;
import com.webpilot.browser.BrowserExecutorImpl;
import com.webpilot.entity.Task;
import com.webpilot.entity.enums.TaskStatus;
import com.webpilot.repository.TaskRepository;
import com.webpilot.websocket.ProgressWebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExecutionService {

    private final DecisionEngine decisionEngine;
    private final TaskRepository taskRepository;
    private final ProgressWebSocketService progressWebSocketService;
    private final BrowserExecutorImpl browserExecutor;

    @Async
    public void runTask(Long taskId, String prompt) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found: " + taskId));

        try {

            task.setStatus(TaskStatus.RUNNING);
            taskRepository.save(task);

            browserExecutor.setTaskId(taskId.toString());

            progressWebSocketService.send(
                    taskId.toString(),
                    "RUNNING",
                    "Task started",
                    null,
                    null
            );

            decisionEngine.runTask(prompt);

            task.setStatus(TaskStatus.COMPLETED);
            taskRepository.save(task);

            progressWebSocketService.send(
                    taskId.toString(),
                    "COMPLETED",
                    "Task completed",
                    null,
                    null
            );

        } catch (Exception e) {

            log.error("Task execution failed", e);

            task.setStatus(TaskStatus.FAILED);
            taskRepository.save(task);

            progressWebSocketService.send(
                    taskId.toString(),
                    "FAILED",
                    e.getMessage(),
                    null,
                    null
            );

        } finally {

            browserExecutor.clearTaskId();

        }
    }
}