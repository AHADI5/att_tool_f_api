package com.example.ulpgl_att_tool_api.Repository;

import com.example.ulpgl_att_tool_api.Modele.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
