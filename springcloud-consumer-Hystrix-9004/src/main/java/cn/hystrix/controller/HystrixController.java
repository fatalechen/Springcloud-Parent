package cn.hystrix.controller;

import cn.common.domain.Department;
import cn.common.service.DeptClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HystrixController {

    @Autowired
    DeptClientService deptClientService;

    private  String str="http://provide";
    @RequestMapping("/findall")
    public List<Department>  test(){
        List<Department> test = deptClientService.test();
        return test;
    }

    @RequestMapping("/hystrix/{id}")
    @HystrixCommand(fallbackMethod = "test2")
    public List<Department>  test1(@PathVariable long id){
        List<Department> test = deptClientService.test1(id);
        System.out.println(test);
        if(test==null ||test.size()==0 ){
            throw  new RuntimeException("出错了");
        }
        return test;
    }

    //@PathVariable long id  不能少，需要与上述的保持一致
    public List<Department>  test2(@PathVariable long id){
        List<Department> depts= new ArrayList<>();
        Department dept = new Department();
        dept.setDname("熔断降级");
        depts.add(dept);
        return depts;
    }
}
