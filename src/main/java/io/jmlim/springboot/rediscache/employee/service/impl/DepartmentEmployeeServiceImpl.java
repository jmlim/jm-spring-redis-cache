package io.jmlim.springboot.rediscache.employee.service.impl;

import io.jmlim.springboot.rediscache.employee.dao.DepartmentEmployeeRepository;
import io.jmlim.springboot.rediscache.employee.domain.DepartmentEmployee;
import io.jmlim.springboot.rediscache.employee.service.DepartmentEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
//@DF
@Service //("employeeSalaryRepository")
@RequiredArgsConstructor
public class DepartmentEmployeeServiceImpl implements DepartmentEmployeeService {

    private final DepartmentEmployeeRepository departmentEmployeeRepository;

  //  @UseCache(keyName = "DEVELOPMENTEMPLOYEE", cron = "0/5 * * * * *")
    @Override
    public List<DepartmentEmployee> getDevelopmentEmployee() {
        return departmentEmployeeRepository.selectDevelopmentEmployee();
    }
}
