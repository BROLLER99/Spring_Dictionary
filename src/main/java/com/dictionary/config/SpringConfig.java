package com.dictionary.config;

import com.dictionary.DAO.LocalStorage;
import com.dictionary.DAO.RunTimeStorage;
import com.dictionary.DAO.Storage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.dictionary")
@PropertySource("application.properties")
public class SpringConfig {
    private static final int ZERO_FOR_DEFINE_STORAGE_TYPE = 0;
    @Value("${dictionary.type}")
    @Bean
    public Storage storage(String storage) {
        if (storage.length() == ZERO_FOR_DEFINE_STORAGE_TYPE) {
            return new RunTimeStorage();
        }
        return new LocalStorage();
    }
}
