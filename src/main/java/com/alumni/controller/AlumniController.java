package com.alumni.controller;

import com.alumni.model.Alumni;
import com.alumni.service.AlumniService;
import com.alumni.service.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/alumni")
@CrossOrigin(origins = "*")
public class AlumniController {

    private final AlumniService alumniService;

    @Autowired
    public AlumniController(AlumniService alumniService) {
        this.alumniService = alumniService;
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is missing! Please upload a CSV file.");
        }
        
        if (!CSVHelper.hasCSVFormat(file)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file format! Only CSV files are allowed.");
        }
        
        try {
            alumniService.saveCSV(file);
            return ResponseEntity.ok("CSV file uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the file: " + e.getMessage());
        }
    }
}

