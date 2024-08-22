package com.example.ulpgl_att_tool_api.Repository;

import com.example.ulpgl_att_tool_api.Modele.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearRepo extends JpaRepository<SchoolYear, Integer> {
    SchoolYear getSchoolYearByStartYearAndEndYear(int startYear, int endYear);
}
