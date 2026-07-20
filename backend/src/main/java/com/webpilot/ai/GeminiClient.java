package com.webpilot.ai;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class GeminiClient {

    @Value("${gemini.api.key:dummy}")
    private String apiKey;

    @Value("${gemini.model:gemini-2.5-flash-lite}")
    private String model;

    private final RestTemplate restTemplate;

    public String generate(String prompt) {

        if ("dummy".equals(apiKey) || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "Gemini API key is missing. Set gemini.api.key in application.properties."
            );
        }

        String url = String.format(
                "https://generativelanguage.googleapis.com/v1beta/models/%s:generateContent?key=%s",
                model,
                apiKey
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> request = Map.of(
                "contents",
                List.of(
                        Map.of(
                                "parts",
                                List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(request, headers);

        try {

            log.info("=================================================");
            log.info("Calling Gemini");
            log.info("Model : {}", model);
            log.info("API Key Loaded : {}", !"dummy".equals(apiKey));
            log.info("=================================================");

            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );

            return extractText(response.getBody());

        } catch (HttpStatusCodeException ex) {

            log.error("===============================================");
            log.error("Gemini HTTP Error");
            log.error("Status : {}", ex.getStatusCode());
            log.error("Response : {}", ex.getResponseBodyAsString());
            log.error("===============================================");

            throw new RuntimeException(
                    "Gemini HTTP Error : "
                            + ex.getStatusCode()
                            + "\n"
                            + ex.getResponseBodyAsString(),
                    ex
            );

        } catch (Exception ex) {

            log.error("===============================================");
            log.error("Unexpected Gemini Error", ex);
            log.error("===============================================");

            throw new RuntimeException(
                    "Gemini request failed: " + ex.getMessage(),
                    ex
            );
        }
    }

    @SuppressWarnings("unchecked")
    private String extractText(Map<String, Object> body) {

        if (body == null) {
            throw new RuntimeException("Gemini returned an empty response.");
        }

        try {

            List<Map<String, Object>> candidates =
                    (List<Map<String, Object>>) body.get("candidates");

            if (candidates == null || candidates.isEmpty()) {
                throw new RuntimeException("No candidates returned by Gemini.");
            }

            Map<String, Object> content =
                    (Map<String, Object>) candidates.get(0).get("content");

            List<Map<String, Object>> parts =
                    (List<Map<String, Object>>) content.get("parts");

            if (parts == null || parts.isEmpty()) {
                throw new RuntimeException("Gemini response contains no parts.");
            }

            return String.valueOf(parts.get(0).get("text"));

        } catch (Exception e) {

            log.error("Failed to parse Gemini response");
            log.error("Response Body : {}", body);

            throw new RuntimeException("Invalid Gemini response.", e);
        }
    }
}