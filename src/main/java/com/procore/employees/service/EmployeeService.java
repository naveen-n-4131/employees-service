package com.procore.employees.service;

import com.procore.employees.model.Employee;
import com.procore.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Dependency Injection: Spring injects EmployeeRepository instance
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves all employees.
     * @return A list of all employees.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Retrieves an employee by their ID.
     * @param id The ID of the employee.
     * @return An Optional containing the employee if found, or empty if not.
     */
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    /**
     * Creates a new employee.
     * @param employee The employee object to be saved.
     * @return The saved employee object with its generated ID.
     */
    public Employee createEmployee(Employee employee) {
        // You might add validation or other business logic here before saving
        return employeeRepository.save(employee);
    }

    /**
     * Updates an existing employee.
     * @param id The ID of the employee to update.
     * @param employeeDetails The employee object with updated details.
     * @return An Optional containing the updated employee if found, or empty if not.
     */
    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id).map(employee -> {
            // Update fields from employeeDetails
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPosition(employeeDetails.getPosition());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setAge(employeeDetails.getAge());
            return employeeRepository.save(employee);
        });
    }

    /**
     * Deletes an employee by their ID.
     * @param id The ID of the employee to delete.
     * @return true if the employee was found and deleted, false otherwise.
     */
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // You can add methods for custom queries defined in the repository here
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
