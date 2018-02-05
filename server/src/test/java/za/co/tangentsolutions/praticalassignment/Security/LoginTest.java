package za.co.tangentsolutions.praticalassignment.Security;

import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginTest extends BaseMvcTest{


    @Test
    public void requiresAuthentication() throws Exception {
        mockMvc
                .perform(get("/api/v1/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void loginSuccess() throws Exception {
        login("pravin.gordhan","pravin.gordhan")
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").exists())
                .andReturn();
    }

    @Test
    public void authenticationSuccess() throws Exception {
        login("pravin.gordhan","pravin.gordhan")
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").exists())
                .andReturn();
    }

    @Test
    public void authenticationFailed() throws Exception {
        login("user","password")
                .andExpect(status().isUnauthorized());
    }
    @Test
    public void logoutSuccess() throws Exception {

        mockMvc
                .perform(logout());
    }

}