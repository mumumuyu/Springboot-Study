package com.lgd.dao;

import com.lgd.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static{
        departments = new HashMap<Integer,Department>();

        departments.put(101,new Department(101,"销售部"));
        departments.put(102,new Department(102,"采购部"));
        departments.put(103,new Department(103,"运营部"));
        departments.put(104,new Department(104,"教育部"));
        departments.put(105,new Department(105,"工商部"));
    }

    public Collection<Department> getAllDeparment(){
        return departments.values();
    }

    public Department getDeparmentById(int id){
        return departments.get(id);
    }
}
