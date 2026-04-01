package com.project.finance_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.finance_tracker.service.ExportService;

@RestController
@RequestMapping("/export")
@CrossOrigin
public class ExportController {

    @Autowired
    private ExportService exportService;

    @GetMapping("/csv/{userId}")
    public ResponseEntity<byte[]> exportUserTransactions(@PathVariable Long userId) {
        String csvData = exportService.generateCsvForUser(userId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=user_" + userId + "_transactions.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(csvData.getBytes());
    }
}