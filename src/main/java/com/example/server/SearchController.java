package com.example.server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @PostMapping("/search")
    public String search(@RequestBody UserDTO user) {
        System.out.println("Processed: " + user);
        return String.format("Received search request for user: %s (ID: %s)",
                           user.getName(),
                           user.getId());
    }
}
