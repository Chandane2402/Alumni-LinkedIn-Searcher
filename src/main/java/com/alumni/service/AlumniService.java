package com.alumni.service;

import com.alumni.model.Alumni;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface AlumniService {
    
    // ✅ CRUD Operations  
    Alumni saveAlumni(Alumni alumni);  
    List<Alumni> getAllAlumni();  
    Alumni getAlumniById(Long id);  
    Alumni updateAlumni(Long id, Alumni alumni);  
    void deleteAlumni(Long id);  

    // ✅ Search & Filtering  
    List<Alumni> searchAlumniByName(String name);  
    List<Alumni> findAlumniByBatch(int batch);  
    List<Alumni> findAlumniByDepartment(String department);  

    // ✅ CSV Handling  
    void saveCSV(MultipartFile file);  
}
