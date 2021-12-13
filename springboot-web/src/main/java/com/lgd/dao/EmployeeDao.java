package com.lgd.dao;


import com.lgd.pojo.Department;
import com.lgd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer, Employee>();

        employees.put(1,new Employee(1,"lgd1","A123456@qq.com",0,new Department(101,"销售部")));
        employees.put(2,new Employee(2,"lgd2","B123456@qq.com",1,new Department(101,"采购部")));
        employees.put(3,new Employee(3,"lgd3","C123456@qq.com",0,new Department(101,"运营部")));
        employees.put(4,new Employee(4,"lgd4","D123456@qq.com",1,new Department(101,"教育部")));
        employees.put(5,new Employee(5,"lgd5","E123456@qq.com",0,new Department(101,"工商部")));
    }

    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void deleteEmpById(Integer id){
         employees.remove(id);
    }

    private static int initid = 6;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initid++);
        }

        employee.setDepartment(departmentDao.getDeparmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }
}
