package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    private Long attendanceID;
    @ManyToOne
    private ElementConstitutif elementConstitutif ;
    @ManyToOne
    private Student student  ;
    @ManyToOne
    private SchoolYear schoolYear;
    private LocalDateTime dateTime  ;






}
