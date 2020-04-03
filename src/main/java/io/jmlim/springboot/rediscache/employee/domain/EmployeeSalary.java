package io.jmlim.springboot.rediscache.employee.domain;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("EmployeeSalary")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"empNo"})
@ToString(of = {"empNo", "firstName", "lastName"})
public class EmployeeSalary {
    private Long empNo;
    private String firstName;
    private String lastName;
    private String gender;
    private Long empSalary;

    @Builder
    public EmployeeSalary(Long empNo, String firstName, String lastName, String gender, Long empSalary) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.empSalary = empSalary;
    }
}
