package com.example.EvaluationCriteria.repository;
import com.example.EvaluationCriteria.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentrepo<Department> extends JpaRepository<Department, Integer> {


}