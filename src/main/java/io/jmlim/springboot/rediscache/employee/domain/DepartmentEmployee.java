package io.jmlim.springboot.rediscache.employee.domain;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("DepartmentEmployee")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class DepartmentEmployee {
    private String deptNo;
    private String deptName;
    private Long empNo;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private String gender;

    @Builder
    public DepartmentEmployee(String deptNo, String deptName, Long empNo, String firstName, String lastName, Date hireDate, String gender) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.gender = gender;
    }
}
