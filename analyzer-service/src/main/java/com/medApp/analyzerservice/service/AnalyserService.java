package com.medApp.analyzerservice.service;

import com.medApp.analyzerservice.constante.Terminology;
import com.medApp.analyzerservice.dto.PatientDTO;
import com.medApp.analyzerservice.dto.PatientNoteDTO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AnalyserService {
//● le client doit pouvoir sélectionner un patient et ensuite déterminer sa probabilité à
//développer un diabète ;
//● un patient pourra avoir l'un des 4 niveaux de risque suivants :
//○ aucun risque (None),
//○ risque limité (Borderline),
//○ danger (In Danger),
//○ apparition précoce (Early onset).
//● les règles pour déterminer les niveaux de risque sont les suivantes :
//○ aucun risque (None) - Le dossier du patient ne contient aucune note du
//médecin contenant les déclencheurs (terminologie),
//○ risque limité (Borderline) - Le dossier du patient contient deux déclencheurs et
//le patient est âgé de plus de 30 ans,
//○ danger (In Danger) - Dépend de l'âge et du sexe du patient. Si le patient est un
//homme et a moins de 30 ans, alors trois termes déclencheurs doivent être
//présents. Si le patient est une femme et a moins de 30 ans, il faudra quatre
//termes déclencheurs. Si le patient a plus de 30 ans, alors il en faudra six.
//○ apparition précoce (Early onset) - Encore une fois, cela dépend de l'âge et du
//sexe. Si le patient est un homme et a moins de 30 ans, alors cinq termes
//déclencheurs sont nécessaires. Si le patient est une femme et a moins de 30
//ans, il faudra sept termes déclencheurs. Si le patient a plus de 30 ans, alors il en
//faudra huit ou plus.
//● les termes déclencheurs à rechercher dans les notes du prestataire de santé sont les
//suivants :
//○ Hémoglobine A1C,
//○ Microalbumine,
//○ Taille,
//○ Poids,
//○ Fumeur,
//○ Anormal,
//○ Cholestérol,
//○ Vertige,
//○ Rechute,
//○ Réaction,
//○ Anticorps.
    //TODO : calcule de l'age du patient chronoUnit.YEARS.between(birthDate, now);
    public long getAge(PatientDTO patient) {
        return ChronoUnit.YEARS.between(patient.getDob(), LocalDate.now());
    }

    //TODO : calcule du nombre de trigger dans toutes les notes du patient patientNoteDTO.getNotes()





    //TODO : déterminer le niveau de risque en fonction de l'age et du nombre de trigger et du sexe
    //TODO : retourner le niveau de risque

    public String determineRiskLevel() {
        String riskLevel = "None";
        int triggerCount = 0;

        if (triggerCount == 0) {
            riskLevel = "None";
        } else if (patientAge > 30 && triggerCount == 2) {
            riskLevel = "Borderline";
        } else if (triggerCount == 3) {
            riskLevel = "In Danger";
        } else if (triggerCount == 5) {
            riskLevel = "Early onset";
        }

    }


}
