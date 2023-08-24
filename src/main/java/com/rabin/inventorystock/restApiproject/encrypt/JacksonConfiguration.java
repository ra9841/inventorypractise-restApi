package com.rabin.inventorystock.restApiproject.encrypt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.rabin.inventorystock.restApiproject.entity.UserEntity;

@Configuration
public class JacksonConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(UserEntity.class, new ProtectDataSerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }
}