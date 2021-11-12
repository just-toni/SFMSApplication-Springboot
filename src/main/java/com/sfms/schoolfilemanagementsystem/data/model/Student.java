package com.sfms.schoolfilemanagementsystem.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@RequiredArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long studentId;
    @NonNull
    private String name;
    @NonNull
    private LocalDate dateOfBirth;
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    Set<Teacher> teachers;
    @JoinColumn(name = "parent_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Parent parent;
    @JoinColumn(name = "class_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Class classes;
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private Set<Subject> subject;

}
