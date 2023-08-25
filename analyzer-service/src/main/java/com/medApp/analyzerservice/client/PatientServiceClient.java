package com.medApp.analyzerservice.client;


import com.medApp.analyzerservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "patient-service", url = "${feign.patient-service.url}")
public interface PatientServiceClient {


    @GetMapping("/patient/{id}")
    PatientDTO getPatient(@PathVariable("id") Long id);

    @GetMapping("/patientsByFamilyName")
    List<PatientDTO> findPatientsByFamilyName(@RequestParam("familyName") String familyName);
}



