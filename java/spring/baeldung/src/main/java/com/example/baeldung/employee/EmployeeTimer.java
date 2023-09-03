package com.example.baeldung.employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeTimer {

    private final EmployeeRepository employeeRepository;

    public EmployeeTimer(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @Scheduled(fixedDelay = 10000)
    public void schedule() {
        Employee employee = new Employee();
        employee.setFirstName("Alice");
        employee.setLastName("Bedow");
        employeeRepository.save(employee);
        System.out.println(employeeRepository.findByFirstName("Alice").getLastName());
        System.out.println(employeeRepository.retrieveByName("alice").getLastName());
        employeeRepository.deleteById(employee.getId());
        System.out.println(employeeRepository.findAll());
    }
}
