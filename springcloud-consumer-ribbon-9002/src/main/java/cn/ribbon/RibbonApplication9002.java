package cn.ribbon;

import cn.ribbon.irule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//为某某服务提供负载均衡
@RibbonClient(name = "provide", configuration = MySelfRule.class)
public class RibbonApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication9002.class,args);
    }
}
