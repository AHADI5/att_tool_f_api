package com.example.ulpgl_att_tool_api.Service;

import com.example.ulpgl_att_tool_api.Dtos.ECDto;
import com.example.ulpgl_att_tool_api.Dtos.UEDto;
import com.example.ulpgl_att_tool_api.Modele.ElementConstitutif;
import com.example.ulpgl_att_tool_api.Modele.UniteEnseignement;
import com.example.ulpgl_att_tool_api.Repository.ECRepo;
import com.example.ulpgl_att_tool_api.Repository.UERepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public record UEService(
        UERepo uERepo ,
        ECRepo ecRepo
) {

    public List<UEDto> registerUE(List<UEDto> ueDtoList ) {
        List<UniteEnseignement> UniteEnseignementList = new ArrayList<>();
        List<UEDto> UEDtoList = new ArrayList<>();
        for (UEDto ueDto : ueDtoList) {
            List<ElementConstitutif> elementConstitutifList = new ArrayList<>();
            for (ECDto ecDto : ueDto.elementConstitutifList()) {
                ElementConstitutif elementConstitutif = ElementConstitutif
                        .builder()
                        .tpHours(ecDto.tpHours())
                        .cmiHours(ecDto.cmiHours())
                        .tdHours(ecDto.tdHours())
                        .build();
                elementConstitutifList.add(ecRepo.save(elementConstitutif));
            }
            UniteEnseignement uniteEnseignement = UniteEnseignement
                    .builder()
                    .level(ueDto.level())
                    .credits(ueDto.credits())
                    .description(ueDto.description())
                    .filiare(ueDto.filiare())
                    .titular(ueDto.titular())
                    .name(ueDto.name())
                    .elementConstitutifList(elementConstitutifList)
                    .build() ;
            UniteEnseignementList.add(uERepo.save(uniteEnseignement)) ;

        }

        for (UniteEnseignement uniteEnseignement : UniteEnseignementList) {
            UEDto uedto = new UEDto(
                    uniteEnseignement.getName(),
                    uniteEnseignement.getDescription(),
                    uniteEnseignement.getTitular() ,
                    uniteEnseignement.getCredits(),
                    uniteEnseignement.getFiliare(),
                    uniteEnseignement.getLevel(),
                    getEcSimpleForm(uniteEnseignement.getElementConstitutifList())

            );
            UEDtoList.add(uedto);
        }
        return UEDtoList;

    }

    public List<ECDto> getEcSimpleForm (List<ElementConstitutif> elementConstitutifList) {
        List<ECDto> ecDtoList = new ArrayList<>();
        for (ElementConstitutif elementConstitutif : elementConstitutifList) {
            ECDto ecDto = new ECDto(
                    elementConstitutif.getEcName() ,
                    elementConstitutif.getCmiHours(),
                    elementConstitutif.getTdHours(),
                    elementConstitutif.getTpHours()
            );
            ecDtoList.add(ecDto);

        }
        return ecDtoList;
    }
    public List<UEDto> syncUEDtoList() {
        List<UEDto> UEDtoList = new ArrayList<>();
        List<UniteEnseignement> uniteEnseignements  = uERepo.findAll() ;
        for (UniteEnseignement uniteEnseignement : uniteEnseignements) {
            UEDto UEDto = new UEDto(
                    uniteEnseignement.getName() ,
                    uniteEnseignement.getDescription(),
                    uniteEnseignement.getTitular(),
                    uniteEnseignement.getCredits() ,
                    uniteEnseignement.getFiliare(),
                    uniteEnseignement.getLevel() ,
                    getEcSimpleForm(uniteEnseignement.getElementConstitutifList())
            ) ;
            UEDtoList.add(UEDto);
        }
        return UEDtoList;
    }

}
