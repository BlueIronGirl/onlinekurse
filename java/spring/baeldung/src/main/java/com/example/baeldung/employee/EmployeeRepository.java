package com.example.baeldung.employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();

    Employee findByFirstName(String firstName);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) = LOWER(:name) OR LOWER(e.lastName) = LOWER(:name)")
    Employee retrieveByName(@Param("name") String name);
}
