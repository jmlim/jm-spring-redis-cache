package io.jmlim.springboot.rediscache.employee.dao;

import io.jmlim.springboot.rediscache.employee.domain.EmployeeSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface EmployeeSalaryRepository {
    List<EmployeeSalary> selectEmployeeSalary(@Param("gender") String gender);
    List<EmployeeSalary> selectEmployeeSalaryGreaterThan(@Param("empSalary") Integer empSalary);
}
