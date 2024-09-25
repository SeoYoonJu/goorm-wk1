package org.learning.goormquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class GoormQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoormQuizApplication.class, args);
    }

}
