package com.sfms.schoolfilemanagementsystem.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDto {
    private String studentName;
    private String dateOfBirth;
}
