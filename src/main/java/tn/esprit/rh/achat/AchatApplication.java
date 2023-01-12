package tn.esprit.rh.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AchatApplication {

    public static void main(String[] args) {
         String MYSQL_HOST = System.getenv("MYSQL_HOST");
        System.out.println(MYSQL_HOST);
        SpringApplication.run(AchatApplication.class, args);
    }

}
