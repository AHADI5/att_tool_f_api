package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class ElementConstitutif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ecID;
    private String ecName;
    private int cmiHours;
    private int tdHours;
    private int tpHours;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "ue_id")
    private UniteEnseignement uniteEnseignement;

    @OneToMany(mappedBy = "elementConstitutif", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendanceList;
}

