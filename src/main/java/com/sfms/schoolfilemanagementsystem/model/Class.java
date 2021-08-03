package com.sfms.schoolfilemanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Class {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long classId;
    @NonNull
    private String className;
    @NonNull
    @Enumerated(EnumType.STRING)
    private ClassType classType;
    @OneToMany(mappedBy = "classes", fetch = FetchType.LAZY)
    @NonNull
    @Column(name = "class_student")
    private Set<Student> students = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "subject_class", joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    Set<Subject> subject;
    @ManyToMany(mappedBy = "classes", fetch = FetchType.LAZY)
    private Set<Teacher> teachers;
}
