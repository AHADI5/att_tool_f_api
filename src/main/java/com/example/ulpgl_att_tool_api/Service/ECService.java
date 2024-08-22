package com.example.ulpgl_att_tool_api.Service;

import com.example.ulpgl_att_tool_api.Repository.ECRepo;
import org.springframework.stereotype.Service;

@Service
public record ECService(
  ECRepo ecRepo

) {


}
