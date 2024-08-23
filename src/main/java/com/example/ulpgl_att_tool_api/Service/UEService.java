package com.example.ulpgl_att_tool_api.Service;

import com.example.ulpgl_att_tool_api.Dtos.ECDto;
import com.example.ulpgl_att_tool_api.Dtos.UEDto;
import com.example.ulpgl_att_tool_api.Modele.ElementConstitutif;
import com.example.ulpgl_att_tool_api.Modele.UniteEnseignement;
import com.example.ulpgl_att_tool_api.Repository.ECRepo;
import com.example.ulpgl_att_tool_api.Repository.UERepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public record UEService(
        UERepo uERepo,
        ECRepo ecRepo
) {

    public List<UEDto> registerUE(List<UEDto> ueDtoList) {
        List<UniteEnseignement> uniteEnseignementList = new ArrayList<>();
        List<UEDto> ueDtoListResult = new ArrayList<>();

        for (UEDto ueDto : ueDtoList) {
            // Initialize a new list of ElementConstitutif for each UniteEnseignement
            List<ElementConstitutif> elementConstitutifList = new ArrayList<>();

            for (ECDto ecDto : ueDto.elementConstitutifList()) {
                ElementConstitutif elementConstitutif = ElementConstitutif.builder()
                        .ecName(ecDto.ecName())
                        .tpHours(ecDto.tpHours())
                        .cmiHours(ecDto.cmiHours())
                        .tdHours(ecDto.tdHours())
                        .build();
                elementConstitutifList.add(elementConstitutif);
            }

            UniteEnseignement uniteEnseignement = UniteEnseignement.builder()
                    .level(ueDto.level())
                    .credits(ueDto.credits())
                    .description(ueDto.description())
                    .filiare(ueDto.filiare())
                    .titular(ueDto.titular())
                    .name(ueDto.name())
                    .elementConstitutifList(elementConstitutifList) // Associate ECs with UE
                    .build();

            // Associate UniteEnseignement with each ElementConstitutif
            for (ElementConstitutif elementConstitutif : elementConstitutifList) {
                elementConstitutif.setUniteEnseignement(uniteEnseignement);
            }

            // Save UniteEnseignement, which cascades to ElementConstitutif
            uniteEnseignementList.add(uERepo.save(uniteEnseignement));
        }

        // Convert saved UniteEnseignements to DTOs
        for (UniteEnseignement uniteEnseignement : uniteEnseignementList) {
            UEDto ueDtoResult = new UEDto(
                    uniteEnseignement.getName(),
                    uniteEnseignement.getDescription(),
                    uniteEnseignement.getTitular(),
                    uniteEnseignement.getCredits(),
                    uniteEnseignement.getFiliare(),
                    uniteEnseignement.getLevel(),
                    getEcSimpleForm(uniteEnseignement.getElementConstitutifList())
            );
            ueDtoListResult.add(ueDtoResult);
        }

        return ueDtoListResult;
    }

    public List<ECDto> getEcSimpleForm(List<ElementConstitutif> elementConstitutifList) {
        List<ECDto> ecDtoList = new ArrayList<>();
        for (ElementConstitutif elementConstitutif : elementConstitutifList) {
            ECDto ecDto = new ECDto(
                    elementConstitutif.getEcName(),
                    elementConstitutif.getCmiHours(),
                    elementConstitutif.getTdHours(),
                    elementConstitutif.getTpHours()
            );
            ecDtoList.add(ecDto);
        }
        log.info("Element constitutif : {}", ecDtoList);
        return ecDtoList;
    }

    public List<UEDto> syncUEDtoList() {
        List<UEDto> ueDtoList = new ArrayList<>();
        List<UniteEnseignement> uniteEnseignements = uERepo.findAll();

        for (UniteEnseignement uniteEnseignement : uniteEnseignements) {
            UEDto ueDto = new UEDto(
                    uniteEnseignement.getName(),
                    uniteEnseignement.getDescription(),
                    uniteEnseignement.getTitular(),
                    uniteEnseignement.getCredits(),
                    uniteEnseignement.getFiliare(),
                    uniteEnseignement.getLevel(),
                    getEcSimpleForm(uniteEnseignement.getElementConstitutifList())
            );
            ueDtoList.add(ueDto);
        }

        return ueDtoList;
    }
}
