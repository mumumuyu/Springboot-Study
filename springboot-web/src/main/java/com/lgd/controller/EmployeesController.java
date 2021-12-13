package com.lgd.controller;

import com.lgd.dao.DepartmentDao;
import com.lgd.dao.EmployeeDao;
import com.lgd.pojo.Department;
import com.lgd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeesController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String Alllist(Model model){
        Collection<Employee> allEmployee = employeeDao.getAllEmployee();
        model.addAttribute("emps",allEmployee);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String addlist(Model model){
        Collection<Department> allDeparment = departmentDao.getAllDeparment();
        model.addAttribute("departments",allDeparment);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String addto(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String updatelist(@PathVariable("id") Integer id,Model model){
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employeeById);
        Collection<Department> allDeparment = departmentDao.getAllDeparment();
        model.addAttribute("departments",allDeparment);
        return "/emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateto(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delemp/{id}")
    public String deleemp(@PathVariable("id")Integer id){
        employeeDao.deleteEmpById(id);
        return "redirect:/emps";
    }
}
