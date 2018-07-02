package com.finance.testproject.configuration;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

import static java.util.Collections.singletonList;

@EnableWebMvc
@ComponentScan("com.finance.testproject")
public class AppConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(new YAMLMapper());
        converter.setSupportedMediaTypes(singletonList(MEDIA_TYPE_YAML));
        converters.add(converter);
    }
}
