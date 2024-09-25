package com.example.ProjetTest.dto;

import com.example.ProjetTest.models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IPatientMapper {

    // Instanciation du mapper
    IPatientMapper INSTANCE = Mappers.getMapper(IPatientMapper.class);


    @Mapping(source = "nom", target = "lastName")
    @Mapping(source = "prenom", target = "firstName")
    @Mapping(source = "datenaissance", target = "birthDate")
    @Mapping(source = "maladie", target = "hasDisease")
    PatientDTO toDto(Patient patient);

    @Mapping(source = "lastName", target = "nom")
    @Mapping(source = "firstName", target = "prenom")
    @Mapping(source = "birthDate", target = "datenaissance")
    @Mapping(source = "hasDisease", target = "maladie")
    Patient toEntity(PatientDTO patientDTO);
}
