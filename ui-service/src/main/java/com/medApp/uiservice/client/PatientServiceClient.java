package com.medApp.uiservice.client;

import com.medApp.uiservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "patient-service", url = "${feign.patient-service.url}")
public interface PatientServiceClient {

    @GetMapping("/patients")
    ResponseEntity<Iterable<PatientDTO>> findAllPatients();

    @PostMapping("/patient/add")
    ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patient);

    @PutMapping("/updatePatient/{id}")
    ResponseEntity<PatientDTO> updatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO patient);

    @GetMapping("/patient/{id}")
    ResponseEntity<PatientDTO> findPatientById(@PathVariable("id") Long id);
}
