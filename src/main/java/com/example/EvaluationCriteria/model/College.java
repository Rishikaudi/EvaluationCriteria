package com.example.EvaluationCriteria.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collegeid;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String website;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Faculty> faculty;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Department> departments;
}
