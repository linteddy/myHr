package za.co.tangentsolutions.praticalassignment.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import za.co.tangentsolutions.praticalassignment.domain.ApplicationUser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static za.co.tangentsolutions.praticalassignment.security.SecurityConstants.HEADER_STRING;
import static za.co.tangentsolutions.praticalassignment.security.SecurityConstants.SECRET;
import static za.co.tangentsolutions.praticalassignment.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthorizationFilter  extends BasicAuthenticationFilter{
    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            LinkedHashMap map = (LinkedHashMap) Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .get("user");
            ApplicationUser user = convertLinkedHashMapToApplicationUser(map);
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, user.getPassword(), new ArrayList<>());
            }
            return null;
        }
        return null;
    }

    private ApplicationUser convertLinkedHashMapToApplicationUser(LinkedHashMap linkedHashMap){

        String username = linkedHashMap.get("username").toString();
        List authorities = (List) linkedHashMap.get("authorities");
        boolean accountNonExpired = Boolean.parseBoolean(linkedHashMap.get("accountNonExpired").toString());
        boolean accountNonLocked = Boolean.parseBoolean(linkedHashMap.get("accountNonLocked").toString());
        boolean credentialsNonExpired = Boolean.parseBoolean(linkedHashMap.get("credentialsNonExpired").toString());
        boolean enabled = Boolean.parseBoolean(linkedHashMap.get("enabled").toString());
        String token  = linkedHashMap.get("token").toString();

        ApplicationUser applicationUser = new ApplicationUser(username,"",enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,
                authorities);
        applicationUser.setToken(token);
        return applicationUser;
    }
}