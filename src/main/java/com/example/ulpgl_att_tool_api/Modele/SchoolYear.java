package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SchoolYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specify strategy for better control
    private Long schoolYearId;
    private int startYear;
    private int endYear;

    @OneToMany(mappedBy = "schoolYear", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;
}
