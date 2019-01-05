package cn.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
/*
    其实这里只是一个将数据转换为显示面板的工具，
    而真正实现的还是熔断器自身，需要熔断器有数据，那么需要访问触发熔断器，
    否则ping的时候没有相应的data
 */
public class DashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }
}
