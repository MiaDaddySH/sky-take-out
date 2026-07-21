package com.sky.controller.admin;

import com.sky.entity.Employee;
import com.sky.mapper.EmployeeMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DatabaseTestController {

    private final EmployeeMapper employeeMapper;

    public DatabaseTestController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/database")
    public String testDatabase() {
        Employee employee = employeeMapper.getByUsername("admin");

        return employee == null
                ? "MySQL连接成功，但没有找到admin用户"
                : "MySQL连接成功，找到用户：" + employee.getUsername();
    }
}