package com.resume.config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.resume")
@PropertySource("classpath:application.properties")
public class WebMvcConfig implements WebMvcConfigurer {

    private final Environment environment;

    public WebMvcConfig(Environment environment) {
        this.environment = environment;
    }

    private Set<IDialect> getAdditionalDialects() {
        Set<IDialect> iDialects = new HashSet<>();
        iDialects.add(new SpringSecurityDialect());

        return iDialects;
    }

    private ClassLoaderTemplateResolver getClassLoaderTemplateResolver() {
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setPrefix(environment.getProperty("spring.mvc.view.prefix", "/templates/"));
        classLoaderTemplateResolver.setSuffix(environment.getProperty("spring.mvc.view.suffix", ".html"));
        classLoaderTemplateResolver.setCacheable(Boolean.parseBoolean(environment.getProperty("spring.mvc.view.cachable", "false")));

        return classLoaderTemplateResolver;
    }

    private SpringTemplateEngine getSpringTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(this.getClassLoaderTemplateResolver());
        springTemplateEngine.setAdditionalDialects(this.getAdditionalDialects());

        return springTemplateEngine;
    }

    @Bean
    ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(this.getSpringTemplateEngine());

        return thymeleafViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler(environment.getProperty("spring.mvc.static-path-pattern", "/**"))
                .addResourceLocations(environment.getProperty("spring.mvc.static-path-location", "classpath:static/"));
    }
}
