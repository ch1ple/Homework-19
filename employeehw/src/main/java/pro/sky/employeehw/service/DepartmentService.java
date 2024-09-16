package pro.sky.employeehw.service;

import pro.sky.employeehw.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Number getMaxSalary(int departmentId);

    Number getMinSalary(int departmentId);

    List<Employee> getAllEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> employeesGroupedByDepartment();

    Number calcTotalSalaryByDepartment(int departmentId);

}