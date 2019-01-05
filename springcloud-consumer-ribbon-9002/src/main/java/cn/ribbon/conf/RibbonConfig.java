package cn.ribbon.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    public RestTemplate  restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public IRule  iRule(){
        /**更换负载均衡算法
         * RandomRule随机
         * RoundRobinRule轮询
         * etryRule() 当轮询访问不了时，尝试询问，几次后不成功，就不再访问
         */
        return  new RandomRule();
    }

}
