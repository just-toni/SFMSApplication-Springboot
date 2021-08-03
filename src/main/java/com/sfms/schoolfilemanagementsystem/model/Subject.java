package com.sfms.schoolfilemanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long subjectId;
    @NonNull
    private String subjectName;
    private String subjectDescription;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;
    @ManyToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private Set<Teacher> teacher;
    @ManyToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private Set<Class> classes;
}
