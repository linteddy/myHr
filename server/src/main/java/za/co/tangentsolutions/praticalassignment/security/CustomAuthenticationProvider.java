package za.co.tangentsolutions.praticalassignment.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import za.co.tangentsolutions.praticalassignment.domain.ApplicationUser;
import za.co.tangentsolutions.praticalassignment.domain.Token;
import za.co.tangentsolutions.praticalassignment.dto.LoginDetails;

import java.util.ArrayList;

@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApplicationUser applicationUser = new ApplicationUser(((LoginDetails) authentication.getPrincipal()).getUsername(), authentication.getCredentials().toString(), new ArrayList<>());
        try {

            LoginDetails loginDetails = LoginDetails.builder().username(applicationUser.getUsername()).password(applicationUser.getPassword()).build();
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://staging.tangent.tngnt.co/api-token-auth/";
            HttpEntity<LoginDetails> httpEntity = new HttpEntity<>(loginDetails);
            ResponseEntity<Token> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Token.class);
            applicationUser.setToken(responseEntity.getBody().getToken());
            log.debug("login successful");

        } catch (Exception e) {

            return null;
        }
        return new UsernamePasswordAuthenticationToken(applicationUser, applicationUser.getPassword(), new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
