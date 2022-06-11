package com.atlantis.security;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Profile("test")
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/**");
//    }
//
//}
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public SpringSecurityConfiguration() {
        super(true); // Disable defaults
    }

    @Override
    protected void configure(HttpSecurity http) {

    }
}