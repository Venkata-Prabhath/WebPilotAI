package com.webpilot.agent;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgentContext {

    private String prompt;
    private AgentState state;

}