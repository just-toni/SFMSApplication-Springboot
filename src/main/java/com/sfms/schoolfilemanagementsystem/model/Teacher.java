package com.sfms.schoolfilemanagementsystem.model;

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
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long teacherId;
    @NonNull
    private String name;
    @NonNull
    private LocalDate dateOfBirth;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    Set<Student> students;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_subject", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    Set<Subject> subject;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_class", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    Set<Class> classes;

}
