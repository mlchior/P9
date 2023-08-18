package com.medApp.noteservice.controller;

import com.medApp.noteservice.model.PatientNote;
import com.medApp.noteservice.service.PatientNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/patientNotes")
public class PatientNoteViewController {

    @Autowired
    private PatientNoteService patientNoteService;

    @GetMapping("/view/{patId}")
    public String viewPatientNotes(@PathVariable Long patId, Model model) {
        List<PatientNote> patientNotes = patientNoteService.findNotesByPatientId(patId);
        model.addAttribute("notes", patientNotes);
        return "viewNotes"; // le nom du fichier Thymeleaf pour afficher les notes
    }

    // Pour modifier une note
    @GetMapping("/edit/{noteId}")
    public String editPatientNote(@PathVariable String noteId, Model model) {
        PatientNote note = patientNoteService.getNoteById(noteId); // Vous aurez besoin de cette méthode dans votre service
        model.addAttribute("note", note);
        return "editNote"; // le nom du fichier Thymeleaf pour éditer la note
    }

    @PostMapping("/update/{noteId}")
    public String updatePatientNote(@PathVariable String noteId,
                                    @RequestParam("note") String noteContent,
                                    RedirectAttributes redirectAttributes) {
        try {
            PatientNote updatedNote = patientNoteService.updateNote(noteId, noteContent);
            Long patId = updatedNote.getPatId(); // Supposant que getPatId() existe dans votre modèle PatientNote
            redirectAttributes.addFlashAttribute("message", "Note updated successfully");
            return "redirect:/patientNotes/view/" + patId; // rediriger vers la vue de la note
        } catch (Exception e) {
            Long patId = patientNoteService.getNoteById(noteId).getPatId(); // Récupérer patId en cas d'erreur
            redirectAttributes.addFlashAttribute("error", "An error occurred while updating the note");
            return "redirect:/patientNotes/edit/" + patId; // rediriger vers la page d'édition en cas d'erreur
        }
    }

    // Pour créer une note
    @GetMapping("/add/{patId}")
    public String showAddNotePage(@PathVariable Long patId, Model model) {
        model.addAttribute("patId", patId);
        return "addNote";
    }

    @PostMapping("/add")
    public String addPatientNote(@RequestParam("patId") Long patId,
                                 @RequestParam("note") String note) {
        patientNoteService.addNote(patId, note);
        return "redirect:/patientNotes/view/" + patId; // redirige vers la page de visualisation des notes pour ce patient
    }
}
