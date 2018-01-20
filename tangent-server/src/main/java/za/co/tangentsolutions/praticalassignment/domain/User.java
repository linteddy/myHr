package za.co.tangentsolutions.praticalassignment.domain;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String token;
}
