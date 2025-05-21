package com.ardagurpinar.sports_clash.config;

import com.ardagurpinar.sports_clash.service.GameService;
import com.ardagurpinar.sports_clash.service.GameServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    ModelMapper modelMapper() { return new ModelMapper(); }
}
