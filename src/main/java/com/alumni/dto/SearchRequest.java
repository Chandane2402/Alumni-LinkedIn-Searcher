package com.alumni.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {

    @NotBlank(message = "University name is required")
    private String university;

    @NotBlank(message = "Designation is required")
    private String designation;

    @Min(value = 1900, message = "Passout year must be a valid year")
    private Integer passoutYear;
}
