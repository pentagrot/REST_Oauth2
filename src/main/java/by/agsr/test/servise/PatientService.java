package by.agsr.test.servise;

import by.agsr.test.model.Patient;

import java.util.UUID;

public interface PatientService {

    Patient createPatient(Patient patient);

    Patient getPatientById(UUID id);

    Patient saveOrUpdatePatient(Patient patient);

    void deletePatientById(UUID id);

}
