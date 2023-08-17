package com.medApp.patientservice.controller;

import com.medApp.patientservice.model.Patient;
import com.medApp.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("/patients")
    public ResponseEntity<Iterable<Patient>> findAllPatients() {
        Iterable<Patient> patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping("/patient/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {
        Patient patientUpdated = patientService.updatePatient(id, patient);
        return new ResponseEntity<>(patientUpdated, HttpStatus.ACCEPTED);
    }


}
