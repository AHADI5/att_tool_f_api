package com.example.ulpgl_att_tool_api.Dtos;

import com.example.ulpgl_att_tool_api.Modele.ElementConstitutif;

import java.util.List;

public record UEDto(
         String name  ,
         String description,
         String titular  ,
         int credits,
         String filiare ,
         int level,
         List<ECDto> elementConstitutifList
) {
}
