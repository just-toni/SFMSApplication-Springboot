package com.sfms.schoolfilemanagementsystem.dto;

import com.sfms.schoolfilemanagementsystem.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDto {
    private  String studentName;
    private String dateOfBirth;
}
