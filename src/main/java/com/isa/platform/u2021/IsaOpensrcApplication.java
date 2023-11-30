package com.isa.platform.u2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IsaOpensrcApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsaOpensrcApplication.class, args);
    }

}
