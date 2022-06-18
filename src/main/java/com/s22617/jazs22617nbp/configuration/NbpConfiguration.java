package com.s22617.jazs22617nbp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NbpConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
