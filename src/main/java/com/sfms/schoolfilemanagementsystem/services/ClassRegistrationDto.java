package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.data.model.ClassType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRegistrationDto {
    private String className;
    private ClassType classType;
}
