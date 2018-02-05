package za.co.tangentsolutions.praticalassignment.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;
import za.co.tangentsolutions.praticalassignment.dto.LoginDetails;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class BaseMvcTest {
    protected MockMvc mockMvc;
    protected ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }


    protected String json(Object o) throws IOException {
        return mapper.writeValueAsString(o);
    }

    protected ResultActions login(String username, String password) throws Exception {
        final LoginDetails auth = new LoginDetails();
        auth.setUsername(username);
        auth.setPassword(password);
        return mockMvc.perform(
                post("/login")
                        .content(json(auth))
                        .contentType(MediaType.APPLICATION_JSON));
    }

    protected String extractToken(MvcResult result) throws UnsupportedEncodingException {
        return JsonPath.read(result.getResponse().getContentAsString(), "$.token");
    }
}
