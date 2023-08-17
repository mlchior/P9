package com.medApp.noteservice.repository;

import com.medApp.noteservice.model.PatientNote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientNoteRepository extends MongoRepository<PatientNote, String> {
    List<PatientNote> findByPatId(Long patId);
}