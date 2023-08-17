package com.medApp.patientservice.controller;

import com.medApp.patientservice.model.Patient;
import com.medApp.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientViewController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/viewPatients")
    public String viewPatients(Model model) {
        List<Patient> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "viewPatients";
    }
    // Method to show the add patient form
    @GetMapping("/viewPatients/add")
    public String showAddPatientForm() {
        return "addPatient";
    }

    // Method to process the submitted add patient form
    @PostMapping("/viewPatients/add")
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/viewPatients"; // Redirect to patient listing page
    }

    @GetMapping("/viewPatients/update/{id}")
    public String showUpdatePatientForm(@PathVariable Long id, Model model) {
        Optional<Patient> patient = Optional.ofNullable(patientService.findPatientById(id));
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "updatePatient";
        } else {
            return "redirect:/viewPatients";
        }
    }

    // Method to process the submitted update patient form
    @PostMapping("/viewPatients/update")
    public String updatePatient(@ModelAttribute Patient patient) {
        patientService.updatePatient(patient.getId(), patient);
        return "redirect:/viewPatients"; // Redirect to patient listing page
    }
}