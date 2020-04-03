package io.jmlim.springboot.rediscache.employee.dao;

import io.jmlim.springboot.rediscache.employee.domain.DepartmentEmployee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentEmployeeRepository {
    List<DepartmentEmployee> selectDevelopmentEmployee();
}
