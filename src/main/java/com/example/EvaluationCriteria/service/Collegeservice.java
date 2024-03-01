package com.example.EvaluationCriteria.service;
import com.example.EvaluationCriteria.model.College;
import com.example.EvaluationCriteria.repository.collegerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Collegeservice {

    @Autowired
    private collegerepo repo;

    public College addCollege(College college) {
        return repo.save(college);
    }

    public List<College> getAllColleges() {
        return repo.findAll();
    }

    public College getCollegeById(int id) {
        Optional<College> optionalCollege = repo.findById(id);
        return optionalCollege.orElse(null);
    }

    public College updateCollege(int id, College updatedCollege) {
        Optional<College> optionalCollege = repo.findById(id);
        if (optionalCollege.isPresent()) {
            College existingCollege = optionalCollege.get();
            existingCollege.setName(updatedCollege.getName());
            existingCollege.setAddress(updatedCollege.getAddress());
            existingCollege.setEmail(updatedCollege.getEmail());
            existingCollege.setPhone(updatedCollege.getPhone());
            existingCollege.setWebsite(updatedCollege.getWebsite());
            // Update other fields as needed
            return repo.save(existingCollege);
        } else {
            return null;
        }
    }

    public boolean deleteCollege(int id) {
        Optional<College> optionalCollege = repo.findById(id);
        if (optionalCollege.isPresent()) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}