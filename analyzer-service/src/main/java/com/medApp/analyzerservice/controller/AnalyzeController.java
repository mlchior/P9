package com.medApp.analyzerservice.controller;

import com.medApp.analyzerservice.dto.PatientAnalyseDTO;
import com.medApp.analyzerservice.service.AnalyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyzeController {

    @Autowired
    private AnalyserService analyserService;
    @PostMapping("/assess/id")
    public ResponseEntity<String> assessById(@RequestParam Long patId) {
        PatientAnalyseDTO result = analyserService.analyzePatient(patId);
        String response = "Patient: " + result.getLastName() + " (age " + result.getAge() + ") diabetes assessment is: " + result.getRiskLevel();
        return ResponseEntity.ok(response);
    }


}