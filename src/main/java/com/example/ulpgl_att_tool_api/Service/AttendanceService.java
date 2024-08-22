package com.example.ulpgl_att_tool_api.Service;

import com.example.ulpgl_att_tool_api.Dtos.AttendanceDto;
import com.example.ulpgl_att_tool_api.Modele.Attendance;
import com.example.ulpgl_att_tool_api.Modele.ElementConstitutif;
import com.example.ulpgl_att_tool_api.Modele.SchoolYear;
import com.example.ulpgl_att_tool_api.Modele.Student;
import com.example.ulpgl_att_tool_api.Repository.ECRepo;
import com.example.ulpgl_att_tool_api.Repository.SchoolYearRepo;
import com.example.ulpgl_att_tool_api.Repository.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service

public record AttendanceService(
        ECRepo ecRepo ,
        StudentRepo studentRepo ,
        SchoolYearRepo schoolYearRepo


) {

    public HttpStatus backUpAttendance(AttendanceDto attendanceDto) {
        ElementConstitutif elementConstitutif = ecRepo.findElementConstitutifByecName(attendanceDto.ecName()) ;
        Student student = studentRepo.getStudentByStudentMat(attendanceDto.matStudent()) ;
        SchoolYear schoolYear = schoolYearRepo.getSchoolYearByStartYearAndEndYear((int) attendanceDto.startYear(), (int) attendanceDto.endYear()) ;

        Attendance attendance = Attendance
                .builder()
                .dateTime(attendanceDto.dateTime())
                .elementConstitutif(elementConstitutif)
                .student(student)
                .schoolYear(schoolYear)
                .build();

        return HttpStatus.OK;
    }

}
