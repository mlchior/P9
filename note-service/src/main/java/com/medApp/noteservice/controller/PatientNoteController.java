package com.medApp.noteservice.controller;

import com.medApp.noteservice.model.PatientNote;
import com.medApp.noteservice.service.PatientNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}