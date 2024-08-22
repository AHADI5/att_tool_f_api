package com.example.ulpgl_att_tool_api.Repository;

import com.example.ulpgl_att_tool_api.Modele.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student getStudentByStudentMat(long studentMat);
}
