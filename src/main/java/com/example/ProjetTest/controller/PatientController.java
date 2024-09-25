package com.example.ProjetTest.controller;

import com.example.ProjetTest.doa.IPatientRepository;
import com.example.ProjetTest.dto.IPatientMapper;
import com.example.ProjetTest.dto.PatientDTO;
import com.example.ProjetTest.models.Patient;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import  com.example.ProjetTest.gestionErreur.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PatientController {

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    IPatientMapper patientMapper=IPatientMapper.INSTANCE;
    @RequestMapping("/all")
    List<PatientDTO> getAll()
    {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDTO> patientDTOs = patients.stream()
                .map(patientMapper::toDto)
                .collect(Collectors.toList());

        return  patientDTOs;
    }
    @PostMapping("/add")
    void addPatient(@RequestBody Patient patient)
    {
        patientRepository.save(patient);
    }

    @PutMapping ("/{id}")
    void updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient)
    {
        Patient patientExist=patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient non trouvé avec l'ID : " + id));
        //Mise a jour des donnees
        patientExist.setNom(patient.getNom());
        patientExist.setPrenom(patient.getPrenom());
        patientExist.setDatenaissance(patient.getDatenaissance());
        patientExist.setMaladie(patient.isMaladie());
        patientExist.setScore(patient.getScore());
        patientRepository.save(patientExist);
    }
}
