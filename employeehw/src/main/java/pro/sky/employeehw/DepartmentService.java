package pro.sky.employeehw;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface DepartmentService {
    Employee findMaxSalaryEmployee(int departmentId);
    Employee findMinSalaryEmployee(int departmentId);
    Collection<Employee> findByDepartment(int departmentId);
    Map<Integer, List<Employee>> groupByDepartment();
}
