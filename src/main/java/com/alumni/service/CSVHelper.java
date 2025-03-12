package com.alumni.service;

import com.alumni.model.Alumni;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    private static final String TYPE = "text/csv";

    // ✅ Check if the uploaded file is in CSV format
    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    // ✅ Convert CSV data into a list of Alumni objects
    public static List<Alumni> csvToAlumni(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim())) {

            // Debug: Print detected headers
            System.out.println("Detected CSV Headers: " + csvParser.getHeaderMap().keySet());

            List<Alumni> alumniList = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                try {
                    Alumni alumni = new Alumni(
                            csvRecord.get("fullName"),      // Change from "name" to "fullName"
                            csvRecord.get("email"),         // Ensure CSV contains "email"
                            csvRecord.get("profileUrl"),    // Change from "linkedin_url" to "profileUrl"
                            Integer.parseInt(csvRecord.get("batch")), // Ensure "batch" exists
                            csvRecord.get("department")     // Ensure "department" exists
                    );
                    alumniList.add(alumni);
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping record due to missing/mismatched data: " + csvRecord);
                }
            }
            return alumniList;

        } catch (IOException e) {
            throw new RuntimeException("Error while parsing CSV file: " + e.getMessage());
        }
    }
}
