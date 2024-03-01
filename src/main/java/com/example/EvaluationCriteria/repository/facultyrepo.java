package com.example.EvaluationCriteria.repository;
import com.example.EvaluationCriteria.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface facultyrepo extends JpaRepository<Faculty,Integer> {

}