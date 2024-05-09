package by.agsr.test.controller;

import by.agsr.test.model.Patient;
import by.agsr.test.servise.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
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
    @Operation(
            summary = "Get a patient by ID",
            description = "Retrieves a patient record by the specified ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Patient not found", content = @Content)
            }
    )
    public Patient getPatient(@PathVariable UUID id) {
        return service.getPatientById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('Patient.Delete')")
    @Operation(
            summary = "Delete a patient by ID",
            description = "Deletes a patient record by the specified ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Successful response"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Patient not found", content = @Content)
            }
    )
    public void deletePatient(@PathVariable UUID id) {
        service.deletePatientById(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('Patient.Write')")
    @Operation(
            summary = "Update a patient",
            description = "Updates an existing patient record",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
            }
    )
    public UUID putPatient(@RequestBody Patient patient) {
        return service.saveOrUpdatePatient(patient).getId();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('Patient.Write')")
    @Operation(
            summary = "Create a new patient",
            description = "Creates a new patient record",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successful response"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
            }
    )
    public UUID createPatient(@RequestBody Patient patient) {
        return service.createPatient(patient).getId();
    }

}
