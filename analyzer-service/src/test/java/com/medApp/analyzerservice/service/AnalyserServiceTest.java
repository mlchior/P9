package com.medApp.analyzerservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.medApp.analyzerservice.constante.RiskLevel;
import com.medApp.analyzerservice.constante.Terminology;
import com.medApp.analyzerservice.dto.PatientNoteDTO;
import com.medApp.analyzerservice.service.AnalyserService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnalyserServiceTest {

    private AnalyserService analyserService;

    @BeforeEach
    void setUp() {
        analyserService = new AnalyserService(null, null);
    }

    @Test
    void testCountTriggers() {
        PatientNoteDTO note1 = new PatientNoteDTO();
        note1.setNote("Hémoglobine A1C Microalbumine Taille");
        PatientNoteDTO note2 = new PatientNoteDTO();
        note2.setNote("Poids Fumeur Anormal Cholestérol");
        List<PatientNoteDTO> notes = Arrays.asList(note1, note2);

        assertEquals(7, analyserService.countTriggers(notes));
    }
    @Test
    void testDetermineRiskLevelMaleUnder30() {
        assertEquals(RiskLevel.EARLY_ONSET, analyserService.determineRiskLevel(25, 5, "m"));
    }

    @Test
    void testDetermineRiskLevelFemaleUnder30() {
        assertEquals(RiskLevel.EARLY_ONSET, analyserService.determineRiskLevel(25, 7, "f"));
    }

    @Test
    void testDetermineRiskLevelNoTriggers() {
        assertEquals(RiskLevel.NONE, analyserService.determineRiskLevel(40, 0, "m"));
    }

    @Test
    void testDetermineRiskLevelBorderline() {
        assertEquals(RiskLevel.BORDERLINE, analyserService.determineRiskLevel(35, 2, "f"));
    }

    @Test
    void testDetermineRiskLevelInDangerMale() {
        assertEquals(RiskLevel.IN_DANGER, analyserService.determineRiskLevel(28, 3, "m"));
    }

    @Test
    void testDetermineRiskLevelInDangerFemale() {
        assertEquals(RiskLevel.IN_DANGER, analyserService.determineRiskLevel(28, 4, "f"));
    }
}