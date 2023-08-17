package com.medApp.noteservice.service;
import com.medApp.noteservice.model.PatientNote;
import com.medApp.noteservice.repository.PatientNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientNoteService {
    @Autowired
    private PatientNoteRepository patientNoteRepository;

    public PatientNote addNote(Long patId, String note) {
        PatientNote patientNote = new PatientNote();
        patientNote.setPatId(patId);
        patientNote.setNote(note);
        return patientNoteRepository.save(patientNote);
    }

    public List<PatientNote> getNotesByPatientId(Long patId) {
        return patientNoteRepository.findByPatId(patId);
    }
}