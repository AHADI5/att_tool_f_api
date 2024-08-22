package com.example.ulpgl_att_tool_api.Repository;

import com.example.ulpgl_att_tool_api.Modele.ElementConstitutif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ECRepo extends JpaRepository<ElementConstitutif , Long> {
    ElementConstitutif findElementConstitutifByecName(String ecName);
}
