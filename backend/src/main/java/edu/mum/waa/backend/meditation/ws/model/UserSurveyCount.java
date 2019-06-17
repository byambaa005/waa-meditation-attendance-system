package edu.mum.waa.backend.meditation.ws.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSurveyCount {
    private Long userId;
    private Long count;
}
