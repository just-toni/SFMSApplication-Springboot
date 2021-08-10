package com.sfms.schoolfilemanagementsystem.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRegistrationDto {
    private String teacherName;
    private String dateOfBirth;
}
