package com.medApp.noteservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "patientNotes")
public class PatientNote {
    @Id
    private String id;
    private Long patId;
    private String note;

    // Getters and Setters
}