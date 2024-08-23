package com.example.ulpgl_att_tool_api.Controllers;

import com.example.ulpgl_att_tool_api.Dtos.AttendanceDto;
import com.example.ulpgl_att_tool_api.Dtos.StudentDto;
import com.example.ulpgl_att_tool_api.Dtos.UEDto;
import com.example.ulpgl_att_tool_api.Service.AttendanceService;
import com.example.ulpgl_att_tool_api.Service.StudentService;
import com.example.ulpgl_att_tool_api.Service.UEService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ulpgl")
public record AttendanceApi(
        AttendanceService attendanceService ,
        StudentService studentService ,
        UEService ueService
) {
    @PostMapping("/attendance")
    public HttpStatus backupData (@RequestBody List<AttendanceDto> attendanceDto) {
        return attendanceService.backUpAttendance(attendanceDto);
    }
    @PostMapping("/student")
    public List<StudentDto> registerStudent (@RequestBody List<StudentDto> studentDto) {
        return studentService.registerStudentList(studentDto) ;
    }
    @GetMapping("/student")
    public List<StudentDto> getStudentList () {
        return  studentService.syncStudent();
    }

    @PostMapping("/courses/create")
    public List<UEDto> registerCourses (@RequestBody List<UEDto> ueDto) {
        return ueService.registerUE(ueDto);
    }
    @GetMapping("/courses")
    public List<UEDto> getCoursesList () {
        return ueService.syncUEDtoList() ;
    }





}
