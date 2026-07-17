package com.webpilot.memory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskMemory {

    private String taskId;
    private String prompt;
    private String status;

}