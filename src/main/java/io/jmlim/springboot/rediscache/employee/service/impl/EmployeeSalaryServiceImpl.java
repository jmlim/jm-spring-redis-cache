package io.jmlim.springboot.rediscache.employee.service.impl;

import io.jmlim.springboot.rediscache.employee.dao.EmployeeSalaryRepository;
import io.jmlim.springboot.rediscache.employee.domain.EmployeeSalary;
import io.jmlim.springboot.rediscache.employee.service.EmployeeSalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

    private final EmployeeSalaryRepository employeeSalaryRepository;

    @Cacheable(value = "getEmployeeSalaryGender", key = "#gender")
    @Override
    public List<EmployeeSalary> getEmployeeSalaryGender(String gender) {
        log.info("----> EmployeeSalaryServiceImpl.getEmployeeSalary");
        return employeeSalaryRepository.selectEmployeeSalary(gender);
    }

    @Cacheable(value = "getEmployeeSalaryGreaterThan1000000")
    @Override
    public List<EmployeeSalary> getEmployeeSalaryGreaterThan1000000() {
        return employeeSalaryRepository.selectEmployeeSalaryGreaterThan(1000000);
    }
}
