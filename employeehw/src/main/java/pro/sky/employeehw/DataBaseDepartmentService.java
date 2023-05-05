package pro.sky.employeehw;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class DataBaseDepartmentService implements DepartmentService{
    @Override
    public Employee findMaxSalaryEmployee(int departmentId) {
        return null;
    }

    @Override
    public Employee findMinSalaryEmployee(int departmentId) {
        return null;
    }

    @Override
    public Collection<Employee> findByDepartment(int departmentId) {
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> groupByDepartment() {
        return null;
    }
}
