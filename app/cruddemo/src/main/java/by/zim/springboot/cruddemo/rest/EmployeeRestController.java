package by.zim.springboot.cruddemo.rest;

import by.zim.springboot.cruddemo.entity.Employee;
import by.zim.springboot.cruddemo.serice.EmployeeSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeSevrice employeeSevrice;

    @Autowired
    public EmployeeRestController(EmployeeSevrice theemployeeSevrice){
        employeeSevrice = theemployeeSevrice;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeSevrice.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeSevrice.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee AddEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        employeeSevrice.save(theEmployee);
        return theEmployee;
    }
}
