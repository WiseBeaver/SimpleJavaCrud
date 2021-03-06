package org.alex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.alex",excludeFilters ={
@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class),
@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class RootConfig {}
