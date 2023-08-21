package com.medApp.noteservice.controller;

import com.medApp.noteservice.model.PatientNote;
import com.medApp.noteservice.service.PatientNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patHistory")
public class PatientNoteController {

    @Autowired
    private PatientNoteService patientNoteService;

    @PostMapping("/add")
    public ResponseEntity<String> addNote(@RequestParam("patId") Long patId,
                                          @RequestParam("note") String note) {
        patientNoteService.addNote(patId, note);
        return new ResponseEntity<>("Note added successfully", HttpStatus.OK);
    }

    @GetMapping("/{patId}")
    public ResponseEntity<List<PatientNote>> getPatientHistory(@PathVariable Long patId) {
        List<PatientNote> patientNotes = patientNoteService.findNotesByPatientId(patId);
        return ResponseEntity.ok(patientNotes);
    }

    @PutMapping("/update/{noteId}")
    public ResponseEntity<String> updateNote(@PathVariable String noteId,
                                             @RequestParam("note") String newNote) {
        try {
            patientNoteService.updateNote(noteId, newNote);
            return new ResponseEntity<>("Note updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the note", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/delete/{noteId}")
    public ResponseEntity<String> deleteNoteById(@PathVariable String noteId) {
        try {
            patientNoteService.deleteNoteById(noteId);
            return new ResponseEntity<>("Note deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the note", HttpStatus.BAD_REQUEST);
        }
    }

}
