package edu.mum.waa.meditation.gui.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserSummary {
    private Long id;
    private String username;
    private List<String> roles;

    public UserSummary() {

    }
}
