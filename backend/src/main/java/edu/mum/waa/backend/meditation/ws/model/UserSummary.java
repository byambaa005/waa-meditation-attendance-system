package edu.mum.waa.backend.meditation.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserSummary {
    private Long id;
    private String username;
    private List<String> roles;
}
