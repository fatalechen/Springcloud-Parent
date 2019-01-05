package cn.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value = "cn.common.service",defaultConfiguration = FeignClientsConfiguration.class)
@EnableCircuitBreaker
public class HystrixApplication9004 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication9004.class,args);
    }
}
