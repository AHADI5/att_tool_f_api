package com.example.ulpgl_att_tool_api.Modele;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private long studentID  ;
    private String studentName ;
    private long studentMat  ;
    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private List<Attendance>  attendances ;


}
