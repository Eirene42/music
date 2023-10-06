package com.irene.music.recordCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("recordCompanies")
public class RecordCompanyController {

    @Autowired
    private RecordCompanyRepository recordCompanyRepository;

    @GetMapping
    public List<RecordCompany> getAllRecordCompanies() {
        return this.recordCompanyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordCompany> getRecordCompany(@PathVariable int id) {
        RecordCompany recordCompany = this.recordCompanyRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "record company not found"));
        return ResponseEntity.ok(recordCompany);
    }

    @PostMapping
    public ResponseEntity<RecordCompany> createRecordCompany(@RequestBody RecordCompany recordCompany) {
        return new ResponseEntity<>(this.recordCompanyRepository.save(recordCompany), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecordCompany> updateRecordCompany(@PathVariable int id, @RequestBody RecordCompany recordCompany) {
        RecordCompany recordCompanyToUpdate = this.recordCompanyRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found to update"));

        recordCompanyToUpdate.setName(recordCompany.getName());
        recordCompanyToUpdate.setLocation(recordCompany.getLocation());
        recordCompanyToUpdate.setEmail(recordCompany.getEmail());

        return new ResponseEntity<>(this.recordCompanyRepository.save(recordCompanyToUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecordCompany> deleteRecordCompany(@PathVariable int id) {
        RecordCompany recordCompanyToDelete = this.recordCompanyRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found to delete"));
        this.recordCompanyRepository.delete(recordCompanyToDelete);

        return ResponseEntity.ok(recordCompanyToDelete);
    }
}
