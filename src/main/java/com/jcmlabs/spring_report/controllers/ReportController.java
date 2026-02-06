package com.jcmlabs.spring_report.controllers;

import com.jcmlabs.spring_report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/employee")
    public ResponseEntity<Resource> downloadEmployeeReport(@RequestParam String fileType) throws Exception {
        byte[] reportBytes = reportService.generateEmployeeReport(fileType.toUpperCase());
        ByteArrayResource resource = new ByteArrayResource(reportBytes);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee_report." + fileType.toLowerCase())
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}

