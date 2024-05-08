package by.agsr.test.controller;

import by.agsr.test.model.Patient;
import by.agsr.test.servise.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('Patient.Read')")
    public Patient getPatient(@PathVariable UUID id) {
        return service.getPatientById(id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('Patient.Delete')")
    public void deletePatient(@PathVariable UUID id) {
        service.deletePatientById(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('Patient.Write')")
    public UUID putPatient(@RequestBody Patient patient) {
        return service.saveOrUpdatePatient(patient).getId();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Patient.Write')")
    public UUID createPatient(@RequestBody Patient patient) {
        return service.createPatient(patient).getId();
    }

}
