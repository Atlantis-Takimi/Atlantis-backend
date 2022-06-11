package com.atlantis.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class h2ServletConfiguration {
    @Bean
    ServletRegistrationBean h2ServletRegistration(){
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");

        return  registrationBean;
    }

}
