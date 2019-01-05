package cn.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
public class ProvideApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication8003.class,args);
    }
}
