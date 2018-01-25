//package za.co.tangentsolutions.praticalassignment.web;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@WebAppConfiguration
//public class LoginTest {
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Autowired
//    private Filter springSecurityFilterChain;
//
//    private MockMvc mvc;
//
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .addFilters(springSecurityFilterChain)
//                .build();
//    }
//
//    @Test
//    public void requiresAuthentication() throws Exception {
//        mvc
//                .perform(get("/"))
//                .andExpect(status().isMovedTemporarily());
//    }
//
//    @Test
//    public void httpBasicAuthenticationSuccess() throws Exception {
//        mvc
//                .perform(get("/api/v1/butnotfound").with(httpBasic("user","password")))
//                .andExpect(status().isNotFound())
//                .andExpect(authenticated().withUsername("user"));
//    }
//
//    @Test
//    public void authenticationSuccess() throws Exception {
//        mvc
//                .perform(formLogin())
//                .andExpect(status().isMovedTemporarily())
//                .andExpect(redirectedUrl("/"))
//                .andExpect(authenticated().withUsername("user"));
//    }
//
//    @Test
//    public void authenticationFailed() throws Exception {
//        mvc
//                .perform(formLogin().user("user").password("invalid"))
//                .andExpect(status().isMovedTemporarily())
//                .andExpect(unauthenticated());
//    }
//
//    @Configuration
//    @EnableWebMvcSecurity
//    @EnableWebMvc
//    static class Config extends WebSecurityConfigurerAdapter {
//        @Autowired
//        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            auth
//                    .inMemoryAuthentication()
//                    .withUser("user").password("password").roles("USER");
//        }
//    }
//}