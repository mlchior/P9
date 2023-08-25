package com.medApp.patientservice.service;

import com.medApp.patientservice.model.Patient;
import com.medApp.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient existingPatient = patientOptional.get();

            // Mettez à jour uniquement les champs qui ont été envoyés dans la requête
            if (updatedPatient.getFamily() != null) {
                existingPatient.setFamily(updatedPatient.getFamily());
            }
            if (updatedPatient.getGiven() != null) {
                existingPatient.setGiven(updatedPatient.getGiven());
            }
            if (updatedPatient.getDob() != null) {
                existingPatient.setDob(updatedPatient.getDob());
            }
            if (updatedPatient.getSex() != null) {
                existingPatient.setSex(updatedPatient.getSex());
            }
            if (updatedPatient.getAddress() != null) {
                existingPatient.setAddress(updatedPatient.getAddress());
            }
            if (updatedPatient.getPhone() != null) {
                existingPatient.setPhone(updatedPatient.getPhone());
            }

            return patientRepository.save(existingPatient);
        } else {
            return null;
        }

    }

    public Patient findPatientById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null);
    }


    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> findPatientsByFamilyName(String familyName) {
        return patientRepository.findByFamily(familyName);
    }
}