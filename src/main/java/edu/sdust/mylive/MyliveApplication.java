package edu.sdust.mylive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.sdust.mylive")
@MapperScan("edu.sdust.mylive")
public class MyliveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyliveApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(MyliveApplication.class);
//    }


}
