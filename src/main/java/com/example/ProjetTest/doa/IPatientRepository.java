package com.example.ProjetTest.doa;

import com.example.ProjetTest.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository  extends JpaRepository<Patient,Long>
{
}
