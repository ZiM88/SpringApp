package by.zim.springboot.cruddemo.serice;

import by.zim.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeSevrice {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
