package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    List<Employee> findAllByNameStartingWith(String name);

    @Query("select e from Employee e where e.name like :name order by e.id")
    List<Employee> findAllByNameLikeJPQL(@Param("name") String name);
}
