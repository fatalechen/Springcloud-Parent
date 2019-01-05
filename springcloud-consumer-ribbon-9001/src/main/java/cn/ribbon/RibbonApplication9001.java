package cn.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication9001.class,args);
    }
}
