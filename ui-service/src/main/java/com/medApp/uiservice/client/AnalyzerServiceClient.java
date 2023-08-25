package com.medApp.uiservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "analyzer-service", url = "${feign.analyzer-service.url}")
public interface AnalyzerServiceClient {

    @PostMapping("/assess/id")
    ResponseEntity<String> getPatientAssessment(@RequestParam("patId") Long patId);
}