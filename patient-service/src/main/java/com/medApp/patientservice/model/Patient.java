package com.medApp.patientservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String family;
    private String given;
    private LocalDate dob;
    private String sex;
    private String address;
    private String phone;




    // Avec Lombok, vous n'avez pas besoin de définir les méthodes getters et setters ici !
}