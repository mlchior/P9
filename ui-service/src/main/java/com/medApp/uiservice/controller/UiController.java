package com.medApp.uiservice.controller;

import com.medApp.uiservice.client.PatientServiceClient;
import com.medApp.uiservice.dto.PatientDTO;
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



    @GetMapping("/viewPatients")
    public String viewPatients(Model model) {
        Iterable<PatientDTO> patients = patientServiceClient.findAllPatients().getBody();
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
        PatientDTO patient = patientServiceClient.findPatientById(id).getBody();
        model.addAttribute("patient", patient);
        return "updatePatient";
    }

    @PostMapping("/viewPatients/update")
    public String updatePatient(@ModelAttribute PatientDTO patient) {
        patientServiceClient.updatePatient(patient.getId(), patient);
        return "redirect:/viewPatients"; // Redirect to patient listing page
    }
}
