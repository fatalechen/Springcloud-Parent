package cn.feign.controller;

import cn.common.domain.Department;
import cn.common.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeignController {

    @Autowired
    DeptClientService deptClientService;

    private  String str="http://provide";
    @RequestMapping("/findall")
    public List<Department>  test(){
        List<Department> test = deptClientService.test();
        return test;
    }

    @RequestMapping("/feign/{id}")
    public List<Department>  test1(@PathVariable long id){
        List<Department> test = deptClientService.test1(id);
        return test;
    }
}
