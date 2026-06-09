package com.example.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @PostMapping("/search")
    public String search(@RequestBody UserDTO user) {
        // Sanitize user input before logging to prevent log injection
        String sanitizedId = sanitizeForLogging(user.getId());
        log.info("Processed search request for user ID: {}", sanitizedId);
        return String.format("Received search request for user: %s (ID: %s)",
                           user.getName(),
                           user.getId());
    }

    /**
     * Sanitizes input for logging to prevent log injection attacks.
     * Removes newlines, carriage returns, and control characters.
     */
    private String sanitizeForLogging(String input) {
        if (input == null) {
            return null;
        }
        // Replace newlines, carriage returns, tabs, and other control characters
        return input.replaceAll("[\n\r\t]", "_")
                    .replaceAll("\\p{Cntrl}", "");
    }
}
