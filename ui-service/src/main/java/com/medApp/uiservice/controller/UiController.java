package com.medApp.uiservice.controller;

import com.medApp.uiservice.client.NoteServiceClient;
import com.medApp.uiservice.client.PatientServiceClient;
import com.medApp.uiservice.dto.PatientDTO;
import com.medApp.uiservice.dto.PatientNoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UiController {
    @Autowired
    private PatientServiceClient patientServiceClient; // Client Feign

    @Autowired
    private NoteServiceClient noteServiceClient; // Client Feign
////////////////////// PATIENTS //////////////////////

    @GetMapping("/viewPatients")
    public String viewPatients(Model model) {
        List<PatientDTO> patients = patientServiceClient.findAllPatients();
        model.addAttribute("patients", patients);
        return "viewPatients";
    }

    @GetMapping("/viewPatients/add")
    public String showAddPatientForm() {
        return "addPatient";
    }

    @PostMapping("/viewPatients/add")
    public String addPatient(@ModelAttribute PatientDTO patient) {
        patientServiceClient.addPatient(patient);
        return "redirect:/viewPatients"; // Redirect to patient listing page
    }

    @GetMapping("/viewPatients/update/{id}")
    public String showUpdatePatientForm(@PathVariable Long id, Model model) {
        PatientDTO patient = patientServiceClient.getPatient(id);
        model.addAttribute("patient", patient);
        return "updatePatient";
    }

    @PostMapping("/viewPatients/update")
    public String updatePatient(@ModelAttribute PatientDTO patient) {
        patientServiceClient.updatePatient(patient.getId(), patient);
        return "redirect:/viewPatients"; // Redirect to patient listing page
    }



//////////// NOTES CONTROLLER ////////////////

@GetMapping("/patientNotes/{patId}")
public String viewPatientNotes(@PathVariable Long patId, Model model) {
    ResponseEntity<List<PatientNoteDTO>> response = noteServiceClient.getPatientHistory(patId);
    model.addAttribute("notes", response.getBody());
    model.addAttribute("patId", patId);
    return "patientNotes"; // Vue Thymeleaf pour afficher les notes
}

    @GetMapping("/patientNotes/add/{patId}")
    public String showAddNoteForm(@PathVariable Long patId, Model model) {
        model.addAttribute("patId", patId);
        return "addNote"; // Vue Thymeleaf pour ajouter une note
    }

    @PostMapping("/patientNotes/add")
    public String addNote(@RequestParam("patId") Long patId,
                          @RequestParam("note") String note) {
        noteServiceClient.addNote(patId, note);
        return "redirect:/patientNotes/" + patId; // Rediriger vers la liste des notes du patient
    }

    @GetMapping("/patientNotes/edit/{id}")
    public String showEditNoteForm(@PathVariable String id, Model model) {
        // Rechercher la note spécifique ici si nécessaire
        model.addAttribute("noteId", id);
        return "editNote"; // Vue Thymeleaf pour éditer une note
    }

    @PostMapping("/patientNotes/edit")
    public String editNote(@RequestParam("noteId") String noteId,
                           @RequestParam("note") String newNote) {
        noteServiceClient.updateNote(noteId, newNote);
        return "redirect:/patientNotes"; // Rediriger vers la liste des notes
    }





}