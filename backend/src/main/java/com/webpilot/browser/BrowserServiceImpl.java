package com.webpilot.browser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrowserServiceImpl implements BrowserService {

    private final BrowserPlanner browserPlanner;
    private final BrowserExecutor browserExecutor;

    @Override
    public BrowserResult execute(BrowserCommand command) {

        List<BrowserInstruction> instructions =
                browserPlanner.plan(command.getCommand());

        return browserExecutor.execute(instructions);
    }
}