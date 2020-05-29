package com.klbud.discover;

import com.klbud.discover.register.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.klbud.discover.dao.*")
@Import(DynamicDataSourceRegister.class)
public class DiscoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverApplication.class, args);
    }

}
