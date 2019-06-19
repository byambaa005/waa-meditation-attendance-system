package edu.mum.waa.meditation.gui.model;

import lombok.Data;

import java.io.Serializable;

/**
 */
@Data
public class JwtAuthenticationResponse implements Serializable {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse() {
    }
}
