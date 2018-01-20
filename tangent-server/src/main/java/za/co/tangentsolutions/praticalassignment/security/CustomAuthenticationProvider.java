package za.co.tangentsolutions.praticalassignment.security;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import za.co.tangentsolutions.praticalassignment.Token;
import za.co.tangentsolutions.praticalassignment.domain.User;

import java.util.ArrayList;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = (User)authentication.getPrincipal();
        Log.debug("Name = "+user.getUsername()+" , Password = "+user.getPassword());

        RestTemplate restTemplate = new RestTemplate();
        Token token = restTemplate.postForObject("http://staging.tangent.tngnt.co/api-token-auth/",user,Token.class);
        if(token!=null){
            return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(), new ArrayList<>());
        }
        log.debug("login fail");
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
