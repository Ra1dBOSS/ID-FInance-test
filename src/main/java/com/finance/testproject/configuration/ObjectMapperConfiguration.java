package com.finance.testproject.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfiguration {

    @Bean
    public ObjectMapper yamlObjectMapper() {
        ObjectMapper yamlObjectMapper = new ObjectMapper(new YAMLFactory());
        return yamlObjectMapper;
    }
}