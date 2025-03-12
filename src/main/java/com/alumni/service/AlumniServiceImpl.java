package com.alumni.service;

import com.alumni.model.Alumni;
import com.alumni.repository.AlumniRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AlumniServiceImpl implements AlumniService {

    private final AlumniRepository alumniRepository;

    public AlumniServiceImpl(AlumniRepository alumniRepository) {
        this.alumniRepository = alumniRepository;
    }

    @Override
    public Alumni saveAlumni(Alumni alumni) {
        return alumniRepository.save(alumni);
    }

    @Override
    public List<Alumni> getAllAlumni() {
        return alumniRepository.findAll();
    }

    @Override
    public Alumni getAlumniById(Long id) {
        return alumniRepository.findById(id).orElse(null);
    }

    @Override
    public List<Alumni> searchAlumniByName(String name) {
        return alumniRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Alumni> findAlumniByBatch(int batch) {
        return alumniRepository.findByBatch(batch);
    }

    @Override
    public List<Alumni> findAlumniByDepartment(String department) {
        return alumniRepository.findByDepartment(department);
    }

    // ✅ FIXED: Fetch existing record before updating
    @Override
    public Alumni updateAlumni(Long id, Alumni updatedAlumni) {
        return alumniRepository.findById(id).map(alumni -> {
            alumni.setName(updatedAlumni.getName());
            alumni.setEmail(updatedAlumni.getEmail());
            alumni.setLinkedinUrl(updatedAlumni.getLinkedinUrl());
            alumni.setBatch(updatedAlumni.getBatch());
            alumni.setDepartment(updatedAlumni.getDepartment());
            return alumniRepository.save(alumni);
        }).orElse(null); // Or throw an exception
    }

    @Override
    public void deleteAlumni(Long id) {
        alumniRepository.deleteById(id);
    }

    // ✅ CSV Handling
    @Override
    public void saveCSV(MultipartFile file) {
        try {
            List<Alumni> alumniList = CSVHelper.csvToAlumni(file.getInputStream());
            alumniRepository.saveAll(alumniList);
        } catch (IOException e) {
            throw new RuntimeException("Error saving CSV data: " + e.getMessage());
        }
    }
}
