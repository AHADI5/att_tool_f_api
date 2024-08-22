package com.example.ulpgl_att_tool_api.Dtos;

import java.time.LocalDateTime;

public record AttendanceDto(
        String ecName ,
        long matStudent ,
        long startYear ,
        long endYear ,
        LocalDateTime dateTime

) {
}
