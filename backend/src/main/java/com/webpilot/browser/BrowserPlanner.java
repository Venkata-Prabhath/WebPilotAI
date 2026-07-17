package com.webpilot.browser;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrowserPlanner {

    public List<BrowserInstruction> plan(String command) {

        List<BrowserInstruction> instructions = new ArrayList<>();

        command = command.trim();

        if (command.toLowerCase().startsWith("open ")) {

            String url = command.substring(5).trim();

            if (!url.startsWith("http")) {
                url = "https://" + url;
            }

            instructions.add(
                    BrowserInstruction.builder()
                            .action(BrowserAction.OPEN)
                            .target(url)
                            .build()
            );
        }

        else if (command.toLowerCase().startsWith("search ")) {

            String query = command.substring(7);

            instructions.add(
                    BrowserInstruction.builder()
                            .action(BrowserAction.SEARCH)
                            .value(query)
                            .build()
            );
        }

        else if (command.equalsIgnoreCase("back")) {

            instructions.add(
                    BrowserInstruction.builder()
                            .action(BrowserAction.BACK)
                            .build()
            );
        }

        else if (command.equalsIgnoreCase("forward")) {

            instructions.add(
                    BrowserInstruction.builder()
                            .action(BrowserAction.FORWARD)
                            .build()
            );
        }

        else if (command.equalsIgnoreCase("refresh")) {

            instructions.add(
                    BrowserInstruction.builder()
                            .action(BrowserAction.REFRESH)
                            .build()
            );
        }

        return instructions;
    }

}