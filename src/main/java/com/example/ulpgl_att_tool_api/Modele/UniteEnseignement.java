package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class UniteEnseignement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Added strategy
    private Long ueID;

    private String name;
    private String description;
    private String titular;
    private int credits;
    private String filiare;
    private int level;

    @OneToMany(mappedBy = "uniteEnseignement", cascade = CascadeType.ALL)
    private List<ElementConstitutif> elementConstitutifList;
}

