package cn.provide.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.HashMap;

@Configuration
@ComponentScan("cn.common.service")
public class ProvideConfigure {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(destroyMethod = "close",initMethod = "init")
    public DruidDataSource getDataSource() {/*返回需要是DruidDataSource，因为DruidDataSource才有close ，init 方法，假如没有destroyMethod = "close",initMethod = "init"那么会出现(*) property for user to setup错误*/
        return new DruidDataSource();
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        ConfigurationCustomizer configurationCustomizer = x->{
            //设置驼峰命名法
            x.setMapUnderscoreToCamelCase(true);
        };
        return configurationCustomizer;
    }

    //配置druid监控页面
    @Bean
//添加servlet
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> servlet = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");//账户
        map.put("loginPassword", "123456");//密码
        map.put("allow", "");//允许所以用户登录,默认允许所有用户登录
        map.put("deny", "");//拒绝用户登录，可以是ip地址等
        servlet.setInitParameters(map);
        return  servlet;
    }

    @Bean
//添加过滤器
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new WebStatFilter());
        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions", "*.js,*.css,*/druid/*,*.gif,*.jpg,*.png,*.ico");
        filter.setInitParameters(map);
        filter.setUrlPatterns(Arrays.asList("/*"));
        return filter;
    }

}
