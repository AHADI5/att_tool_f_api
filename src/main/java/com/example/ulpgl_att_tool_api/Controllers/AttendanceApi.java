package com.example.ulpgl_att_tool_api.Controllers;

import com.example.ulpgl_att_tool_api.Dtos.AttendanceDto;
import com.example.ulpgl_att_tool_api.Service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ulpgl")
public record AttendanceApi(
        AttendanceService attendanceService
) {
    @PostMapping("/attendance")
    public HttpStatus backupData (@RequestBody AttendanceDto attendanceDto) {
        return attendanceService.backUpAttendance(attendanceDto);
    }
    @GetMapping("/student")


}
