package pl.atom.spring.cqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "pl.atom.spring.cqs")
public class TestCqsApp {

    public static void main(String[] args) {
        SpringApplication.run(TestCqsApp.class);
    }
}
