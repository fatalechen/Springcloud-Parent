package cn.provide.controller;

import cn.common.domain.Department;
import cn.common.domain.DepartmentExample;
import cn.provide.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProvideController {
    @Autowired
    DepartmentMapper deptMapper;

    @RequestMapping("/findall")
    public  List<Department>  test(){
        List<Department> departments = deptMapper.selectByExample(null);
        return  departments;
    }

    @RequestMapping("/provide/{id}")
    public  List<Department>  test(@PathVariable long id){
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDeptNoEqualTo(id);
        List<Department> departments = deptMapper.selectByExample(departmentExample);
        if(departments==null ||departments.size()==0 ){
            throw  new RuntimeException("出错了");
        }
        return  departments;
    }
}
