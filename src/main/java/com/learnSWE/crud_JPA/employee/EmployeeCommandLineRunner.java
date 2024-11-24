package com.learnSWE.crud_JPA.employee;

import com.learnSWE.crud_JPA.employee.spring_jpa.EmployeeSpringJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {

    @Autowired
    EmployeeSpringJpaRepository employeeSpringJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        //CREATE
        employeeSpringJpaRepository.save(
                new Employee("4fj3jds6", "Iman", "Badaui", 25, 500000));
        employeeSpringJpaRepository.save(
                new Employee("f4hs9f5h", "Laila", "Fahmy", 45, 250000));
        employeeSpringJpaRepository.save(
                new Employee("d6hs7j4d", "Aly", "Sami", 25, 150000));
        employeeSpringJpaRepository.save(
                new Employee("s0fn4dg6", "Shady", "Samir", 24, 50000));
        employeeSpringJpaRepository.save(
                new Employee("s3gd56d4", "Rania", "Yousef", 23, 45000));
        employeeSpringJpaRepository.save(
                new Employee("4dg5d5gf", "Noha", "Salama", 22, 20000));

        //READ
        Optional<Employee> optionalEmployee1 = employeeSpringJpaRepository.findById("4fj3jds6");
        Optional<Employee> optionalEmployee2 = employeeSpringJpaRepository.findById("s0fn4dg6");

        optionalEmployee1.ifPresent(System.out::println);
        optionalEmployee2.ifPresent(System.out::println);

        //UPDATE
        optionalEmployee1.ifPresent(employee -> {
            employee.setSalary(600000);
            employeeSpringJpaRepository.save(employee);
        });

        optionalEmployee1.ifPresent(System.out::println);

        //DELETE
        employeeSpringJpaRepository.deleteById("s3gd56d4");

        //Custom Method
        List<Employee> employeesAge25 = employeeSpringJpaRepository.findByAge(25);
        employeesAge25.forEach(System.out::println);
    }
}
