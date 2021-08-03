package com.sfms.schoolfilemanagementsystem.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long parentId;
    @NonNull
    private String name;
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @NonNull
    @Column(name = "parent_student")
    private Set<Student> students = new HashSet<>();
}
