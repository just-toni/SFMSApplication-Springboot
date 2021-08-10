package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServices{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher registerWith(TeacherRegistrationDto teacherRegistrationDto){
        Teacher teacher = new Teacher();
        System.out.println(teacherRegistrationDto.getTeacherName());
        teacher.setName(teacherRegistrationDto.getTeacherName());
        teacher.setDateOfBirth(LocalDate.parse(teacherRegistrationDto.getDateOfBirth()));
        return teacherRepository.save(teacher);
    }

    public void deleteBy(Long id){
        teacherRepository.deleteById(id);
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
}
