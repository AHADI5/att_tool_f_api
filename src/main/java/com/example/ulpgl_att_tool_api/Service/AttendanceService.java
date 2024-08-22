package com.example.ulpgl_att_tool_api.Service;

import com.example.ulpgl_att_tool_api.Dtos.AttendanceDto;
import com.example.ulpgl_att_tool_api.Modele.Attendance;
import com.example.ulpgl_att_tool_api.Modele.ElementConstitutif;
import com.example.ulpgl_att_tool_api.Modele.SchoolYear;
import com.example.ulpgl_att_tool_api.Modele.Student;
import com.example.ulpgl_att_tool_api.Repository.ECRepo;
import com.example.ulpgl_att_tool_api.Repository.SchoolYearRepo;
import com.example.ulpgl_att_tool_api.Repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public record AttendanceService(
        ECRepo ecRepo ,
        StudentRepo studentRepo ,
        SchoolYearRepo schoolYearRepo


) {

    public HttpStatus backUpAttendance(List<AttendanceDto> attendanceDto) {
        List<Attendance> attendanceList = new ArrayList<>();
        for (AttendanceDto attendanceDtoItem : attendanceDto) {
            ElementConstitutif elementConstitutif = ecRepo.findElementConstitutifByecName(attendanceDtoItem.ecName()) ;
            Student student = studentRepo.getStudentByStudentMat(attendanceDtoItem.matStudent()) ;
            SchoolYear schoolYear = schoolYearRepo.getSchoolYearByStartYearAndEndYear((int) attendanceDtoItem.startYear(),
                    (int) attendanceDtoItem.endYear()) ;
            Attendance attendance = Attendance
                    .builder()
                    .dateTime(attendanceDtoItem.dateTime())
                    .elementConstitutif(elementConstitutif)
                    .student(student)
                    .schoolYear(schoolYear)
                    .build();
            attendanceList.add(attendance);

        }

        log.info("Data  received ,successfully  {}" , attendanceList);
        //TODO SAVE  IN  A SMALL DB , FOR TESTING ISSUES

        return HttpStatus.OK;
    }

}
