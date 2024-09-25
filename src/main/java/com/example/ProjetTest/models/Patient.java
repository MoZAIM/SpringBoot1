package com.example.ProjetTest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.internal.GenerationStrategyInterpreter;
import org.springframework.boot.autoconfigure.web.WebProperties;


import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    @Temporal(TemporalType.DATE)
    @Column(name = "datenaissance", nullable = false)
    Date datenaissance;
    boolean maladie;
    int score;
}
