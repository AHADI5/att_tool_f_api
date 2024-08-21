package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementConstitutif {

    @Id
    private Long ecID;
    private String ecName;
    private int cmiHours ;
    private int tdHours ;
    private int tpHours  ;
    @ManyToOne
    private UniteEnseignement uniteEnseignement ;
    @OneToMany(mappedBy = "elementConstitutif")
    private List<Attendance> attendanceList  ;

}
