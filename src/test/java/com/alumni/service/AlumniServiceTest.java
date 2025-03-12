package com.alumni.service;

import com.alumni.repository.AlumniRepository;
import com.alumni.model.Alumni;
import com.alumni.service.AlumniServiceImpl; // Ensure correct package for implementation

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  // ✅ Use Mockito JUnit 5 Extension
class AlumniServiceTest {

    @Mock
    private AlumniRepository alumniRepository;

    @InjectMocks
    private AlumniServiceImpl alumniService; // ✅ Ensure implementation class is tested

    private Alumni alumni1, alumni2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // ✅ Initialize mocks
        
        // ✅ Ensure Alumni class has this constructor in Alumni.java
        alumni1 = new Alumni(1L, "John Doe", "Engineering");
        alumni2 = new Alumni(2L, "Jane Smith", "Science");
    }

    @Test
    void testGetAllAlumni() {
        // ✅ Mock repository behavior
        when(alumniRepository.findAll()).thenReturn(Arrays.asList(alumni1, alumni2));

        // ✅ Call service method
        List<Alumni> result = alumniService.getAllAlumni();

        // ✅ Verify results
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Smith", result.get(1).getName());

        // ✅ Ensure repository method was called
        verify(alumniRepository, times(1)).findAll();
    }
}



