package za.co.tangentsolutions.praticalassignment.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.tangentsolutions.praticalassignment.domain.ApplicationUser;
import za.co.tangentsolutions.praticalassignment.security.SecurityConstants;

@Service
public class TangentRestService {

    public  <T> T sendRequest(String url, Class<T> responseType) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = ((ApplicationUser) authentication.getPrincipal()).getToken();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(SecurityConstants.HEADER_STRING, "Token " + token);
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);
        return responseEntity.getBody();
    }
}
