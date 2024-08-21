package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolYear {
    @Id
    private Long schoolYearId;
    private int startYear;
    private int endYear;
    @OneToMany(mappedBy = "schoolYear" , cascade = CascadeType.ALL)
    private List<Attendance> attendanceList ;
}
