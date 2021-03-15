package org.alex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("org.alex.controller")
public class WebConfig {
   @Bean
   public SpringResourceTemplateResolver springResourceTemplateResolver(){
      SpringResourceTemplateResolver springResourceTemplateResolver=new SpringResourceTemplateResolver();
      springResourceTemplateResolver.setPrefix("/WEB-INF/views/");
      springResourceTemplateResolver.setSuffix(".html");
      return springResourceTemplateResolver;
   }
   @Bean
   public SpringTemplateEngine templateEngine(){
      SpringTemplateEngine springTemplateEngine=new SpringTemplateEngine();
      springTemplateEngine.setTemplateResolver(springResourceTemplateResolver());
      springTemplateEngine.setEnableSpringELCompiler(true);
      return springTemplateEngine;
   }
   @Bean
   public ThymeleafViewResolver thymeleafViewResolver(){
      ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
      thymeleafViewResolver.setTemplateEngine(templateEngine());
      thymeleafViewResolver.setOrder(1);
      thymeleafViewResolver.setViewNames(new String[]{"*"});
      return thymeleafViewResolver;
   }
}
