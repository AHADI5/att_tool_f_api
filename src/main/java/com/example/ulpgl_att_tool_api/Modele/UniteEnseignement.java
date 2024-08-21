package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UniteEnseignement {
    @Id
    private Long ueID;
    private String name  ;
    private String description;
    private String titular  ;
    private int credits;
    @OneToMany(mappedBy = "uniteEnseignement" , cascade = CascadeType.ALL)
    private List<ElementConstitutif> elementConstitutifList;

}
