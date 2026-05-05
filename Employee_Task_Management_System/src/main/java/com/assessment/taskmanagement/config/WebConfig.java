package com.assessment.taskmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan(basePackages ="com.assessment")
public class WebConfig {
	 @Bean
     public InternalResourceViewResolver viewResolver() {
      InternalResourceViewResolver resolver=new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
     }
}
