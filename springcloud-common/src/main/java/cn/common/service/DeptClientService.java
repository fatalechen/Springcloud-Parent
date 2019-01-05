package cn.common.service;

import cn.common.domain.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value="provide", fallback =DeptClientServiceImpl.class)
public interface DeptClientService {

    @RequestMapping("/findall")
    public List<Department> test();

    @RequestMapping("/provide/{id}")
    //@PathVariable("id")  中的id 不能省略
    public List<Department> test1( @PathVariable("id") Long id);
}
