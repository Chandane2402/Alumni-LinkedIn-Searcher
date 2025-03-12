package com.alumni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.alumni.model.Alumni;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {
    List<Alumni> findByNameContainingIgnoreCase(String name);
    List<Alumni> findByBatch(int batch);
    List<Alumni> findByDepartment(String department);
}
