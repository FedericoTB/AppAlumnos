package com.example.appalumnos;

import com.example.appalumnos.services.uploads.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppAlumnosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppAlumnosApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(StorageService storageService){
        return args -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
