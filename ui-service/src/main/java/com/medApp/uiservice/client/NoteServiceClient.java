package com.medApp.uiservice.client;

import com.medApp.uiservice.dto.PatientNoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "note-service", url = "${feign.note-service.url}")
public interface NoteServiceClient {
    @PostMapping("/patHistory/add")
    ResponseEntity<String> addNote(@RequestParam("patId") Long patId,
                                   @RequestParam("note") String note);

    @GetMapping("/patHistory/{patId}")
    ResponseEntity<List<PatientNoteDTO>> getPatientHistory(@PathVariable Long patId);

    @PutMapping("/patHistory/update/{noteId}")
    ResponseEntity<String> updateNote(@PathVariable String noteId,
                                      @RequestParam("note") String newNote);
    @DeleteMapping("/patHistory/delete/{noteId}")
    ResponseEntity<String> deleteNoteById(@PathVariable String noteId);

    @GetMapping("/patHistory/note/{noteId}")
    ResponseEntity<PatientNoteDTO> getNoteById(@PathVariable String noteId);
}
