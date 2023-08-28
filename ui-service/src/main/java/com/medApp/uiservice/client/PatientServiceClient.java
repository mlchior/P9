package com.medApp.uiservice.client;

import com.medApp.uiservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "patient-service", url = "${feign.patient-service.url}")
public interface PatientServiceClient {

    @GetMapping("/patients")
    List<PatientDTO> findAllPatients();

    @PostMapping("/patient/add")
    ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patient);

    @PutMapping("/updatePatient/{id}")
    ResponseEntity<PatientDTO> updatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO patient);

    @GetMapping("/patient/{id}")
    PatientDTO getPatient(@PathVariable("id") Long id);

    @DeleteMapping("/deletePatient/{id}")
    ResponseEntity<String> deletePatient(@PathVariable("id") Long id);

}
