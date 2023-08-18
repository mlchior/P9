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

    public List<PatientNote> findNotesByPatientId(Long patId) {
        return patientNoteRepository.findByPatId(patId);
    }




    public PatientNote updateNote(String noteId, String newNote) {
        PatientNote patientNote = patientNoteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + noteId + " not found"));

        patientNote.setNote(newNote);
        patientNoteRepository.save(patientNote);
        return patientNote;
    }

    public PatientNote getNoteById(String noteId) {
        return patientNoteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + noteId + " not found"));
    }
}