package cn.common.service;

import cn.common.domain.Department;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DeptClientServiceImpl implements DeptClientService{
    @Override
    public List<Department> test() {
        List<Department> depts= new ArrayList<>();
        Department dept = new Department();
        dept.setDname("熔断降级");
        depts.add(dept);
        return depts;
    }

    @Override
    public List<Department> test1(Long id) {
        List<Department> depts= new ArrayList<>();
        Department dept = new Department();
        dept.setDname("熔断降级");
        depts.add(dept);
        return depts;
    }
}
