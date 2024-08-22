package com.example.ulpgl_att_tool_api.Service;

import com.example.ulpgl_att_tool_api.Dtos.StudentDto;
import com.example.ulpgl_att_tool_api.Modele.Student;
import com.example.ulpgl_att_tool_api.Repository.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public record StudentService(
        StudentRepo studentRepo
) {
    //TODO : register student logic goes here

    public List<StudentDto> registerStudentList(List<StudentDto> sudentList) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (StudentDto student : sudentList) {
            Student studentItem = Student
                    .builder()
                    .studentName(student.studentName())
                    .studentMat(student.studentMat())
                    .build();
            Student savedStudent = studentRepo.save(studentItem);
            studentDtoList.add(new StudentDto(
                    savedStudent.getStudentName(),
                    savedStudent.getStudentMat()
            ));
        }
        return  studentDtoList ;
    }

    public List<StudentDto> syncStudent() {
        /**
         * This function sync all students in the database
         * **/

        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> studentList = studentRepo.findAll();
        for (Student student : studentList) {
            StudentDto studentDto = new StudentDto(
                    student.getStudentName() ,
                    student.getStudentMat()
            );
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }
}
