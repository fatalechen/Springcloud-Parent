package cn.ribbon.controller;

import cn.common.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RibbonController {
    @Autowired
    RestTemplate restTemplate;
    private  String str="http://provide";

    @RequestMapping("/findall")
    public List<Department>  test(){
        ArrayList forObject = restTemplate.getForObject(str+"/findall", (new ArrayList<Department>()).getClass());
        return forObject;
    }

    @RequestMapping("/ribbon/{id}")
    public List<Department>  test1(@PathVariable  long  id  ){
        ArrayList forObject = restTemplate.getForObject(str+"/provide/"+id, (new ArrayList<Department>()).getClass());
        return forObject;
    }
}
