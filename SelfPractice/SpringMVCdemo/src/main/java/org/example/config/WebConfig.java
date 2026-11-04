package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.example")
@EnableWebMvc // for activating annotations such as getMapping and postMapping
public class WebConfig {

}
