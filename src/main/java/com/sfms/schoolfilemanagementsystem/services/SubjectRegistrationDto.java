package com.sfms.schoolfilemanagementsystem.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRegistrationDto {
    private String subjectName;
    private String subjectDescription;
}
