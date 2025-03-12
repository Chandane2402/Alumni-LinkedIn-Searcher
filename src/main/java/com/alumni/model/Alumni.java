package com.alumni.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alumni")
public class Alumni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    private int batch;
    private String department;

    // Default Constructor
    public Alumni() {}

    // Constructor matching test case (includes ID)
    public Alumni(Long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Full Constructor
    public Alumni(String name, String email, String linkedinUrl, int batch, String department) {
        this.name = name;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.batch = batch;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLinkedinUrl() { return linkedinUrl; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }

    public int getBatch() { return batch; }
    public void setBatch(int batch) { this.batch = batch; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}

