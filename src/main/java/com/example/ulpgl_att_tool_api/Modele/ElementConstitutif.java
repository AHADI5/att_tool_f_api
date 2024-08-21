package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ElementConstitutif {

    @Id
    private Long ecID;
    private String ecName;
    private int cmiHours ;
    private int tdHours ;
    private int tpHours  ;
    @ManyToOne
    private UniteEnseignement uniteEnseignement ;

}