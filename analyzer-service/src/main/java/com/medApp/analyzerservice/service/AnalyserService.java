package com.medApp.analyzerservice.service;

import com.medApp.analyzerservice.client.PatientNoteClient;
import com.medApp.analyzerservice.client.PatientServiceClient;
import com.medApp.analyzerservice.constante.RiskLevel;
import com.medApp.analyzerservice.constante.Terminology;
import com.medApp.analyzerservice.dto.PatientAnalyseDTO;
import com.medApp.analyzerservice.dto.PatientDTO;
import com.medApp.analyzerservice.dto.PatientNoteDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
public class AnalyserService {

    private PatientServiceClient patientServiceClient;

    private PatientNoteClient patientNoteClient;

    public AnalyserService(PatientServiceClient patientServiceClient, PatientNoteClient patientNoteClient) {
        this.patientServiceClient = patientServiceClient;
        this.patientNoteClient = patientNoteClient;
    }


    //TODO : calcule de l'age du patient chronoUnit.YEARS.between(birthDate, now);
    public long getAge(PatientDTO patient) {
        return ChronoUnit.YEARS.between(patient.getDob(), LocalDate.now());
    }


    //TODO : calcule du nombre de trigger dans toutes les notes du patient patientNoteDTO.getNotes()

    public int countTriggers(List<PatientNoteDTO> patientNotes) {
        int count = 0;
        for (PatientNoteDTO note : patientNotes) {
            for (String term : Terminology.TERMINOLOGY) {
                if (note.getNote().contains(term)) {
                    count++;
                }
            }
        }
        return count;
    }


    //TODO : déterminer le niveau de risque en fonction de l'age et du nombre de trigger et du sexe
    public RiskLevel determineRiskLevel(long age, int triggerCount, String sex) {
        if (triggerCount == 0) {
            return RiskLevel.NONE;
        } else if (triggerCount == 2 && age > 30) {
            return RiskLevel.BORDERLINE;
        } else if (triggerCount >= 8 || (triggerCount == 5 && age < 30 && "m".equalsIgnoreCase(sex))
                || (triggerCount == 7 && age < 30 && "f".equalsIgnoreCase(sex))) {
            return RiskLevel.EARLY_ONSET;
        } else if (triggerCount >= 6 || (triggerCount == 3 && age < 30 && "m".equalsIgnoreCase(sex))
                || (triggerCount == 4 && age < 30 && "f".equalsIgnoreCase(sex))) {
            return RiskLevel.IN_DANGER;
        }
        return RiskLevel.NONE; // Default case
    }
    //TODO : retourner le niveau de risque
    public PatientAnalyseDTO analyzePatient(Long patientId) {
        PatientDTO patient = patientServiceClient.getPatient(patientId);
        List<PatientNoteDTO> patientNotes = patientNoteClient.getPatientHistory(patientId).getBody();

        long age = getAge(patient);
        int triggerCount = countTriggers(patientNotes);
        RiskLevel riskLevel = determineRiskLevel(age, triggerCount, patient.getSex());

        PatientAnalyseDTO analysis = new PatientAnalyseDTO();
        analysis.setLastName(patient.getFamily());
        analysis.setAge(age);
        analysis.setSex(patient.getSex());
        analysis.setRiskLevel(riskLevel);
        return analysis;
    }


    //TODO : retourner le niveau de risque en fonction du nom de famille
    public PatientAnalyseDTO analyzePatientByFamilyName(String familyName) {
        List<PatientDTO> patients = patientServiceClient.findPatientsByFamilyName(familyName);

        if (patients.isEmpty()) {
            return null;
        }

        PatientDTO patient = patients.get(0);
        List<PatientNoteDTO> patientNotes = patientNoteClient.getPatientHistory(patient.getId()).getBody();

        long age = getAge(patient);
        int triggerCount = countTriggers(patientNotes);
        RiskLevel riskLevel = determineRiskLevel(age, triggerCount, patient.getSex());

        PatientAnalyseDTO analysis = new PatientAnalyseDTO();
        analysis.setLastName(patient.getFamily());
        analysis.setAge(age);
        analysis.setSex(patient.getSex());
        analysis.setRiskLevel(riskLevel);
        return analysis;
    }

}


