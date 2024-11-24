package com.learnSWE.crud_JPA.employee.spring_jpa;

import com.learnSWE.crud_JPA.employee.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeSpringJpaRepository extends JpaRepository<Employee, String> {

    //Custom READ
    List<Employee> findByAge(int age);
}
