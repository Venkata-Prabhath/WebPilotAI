package com.webpilot.service;

import com.webpilot.dto.BrowserAction;

import java.util.List;

public interface AIService {

    List<BrowserAction> generatePlan(String task);

}