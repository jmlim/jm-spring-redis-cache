package io.jmlim.springboot.rediscache.employee.service;

import io.jmlim.springboot.rediscache.employee.domain.EmployeeSalary;

import java.util.List;

public interface EmployeeSalaryService {
    List<EmployeeSalary> getEmployeeSalaryGender(String gender);

    List<EmployeeSalary> getEmployeeSalaryGreaterThan1000000();
}
