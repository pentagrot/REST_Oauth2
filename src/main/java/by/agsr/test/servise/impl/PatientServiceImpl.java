package by.agsr.test.servise.impl;

import by.agsr.test.model.Patient;
import by.agsr.test.repository.PatientRepository;
import by.agsr.test.servise.PatientService;
import by.agsr.test.servise.exception.EntityNotFound;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient getPatientById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Patient with id = " + id + " not found"));
    }

    @Override
    public Patient saveOrUpdatePatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public void deletePatientById(UUID id) {
        repository.delete(getPatientById(id));
    }

}
