package com.medApp.analyzerservice.client;

import com.medApp.analyzerservice.dto.PatientNoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "note-service", url = "${feign.note-service.url}")
public interface PatientNoteClient {

    @GetMapping("/patHistory/{patId}")
    ResponseEntity<List<PatientNoteDTO>> getPatientHistory(@PathVariable Long patId);

}
