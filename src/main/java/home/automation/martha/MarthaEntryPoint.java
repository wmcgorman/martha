package home.automation.martha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
class MarthaEntryPoint {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MarthaEntryPoint.class, args);
    }

}
