package by.agsr.test.controller;

import by.agsr.test.model.Patient;
import by.agsr.test.servise.PatientService;
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
    public Patient getPatient(@PathVariable UUID id) {
        return service.getPatientById(id);
    }

    @DeleteMapping("{id}")
    public void deletePatient(@PathVariable UUID id) {
        service.deletePatientById(id);
    }

    @PutMapping
    public UUID putPatient(@RequestBody Patient patient) {
        return service.saveOrUpdatePatient(patient).getId();
    }

    @PostMapping
    public UUID createPatient(@RequestBody Patient patient) {
        return service.createPatient(patient).getId();
    }

}
