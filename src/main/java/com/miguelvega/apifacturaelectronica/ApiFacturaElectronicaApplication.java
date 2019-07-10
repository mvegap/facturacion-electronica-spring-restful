package com.miguelvega.apifacturaelectronica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiFacturaElectronicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFacturaElectronicaApplication.class, args);
    }

}
