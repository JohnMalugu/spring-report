package com.jcmlabs.spring_report.controllers;

import com.jcmlabs.spring_report.enums.ReportTypeEnum;
import com.jcmlabs.spring_report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadReport(@RequestParam ReportTypeEnum type) throws Exception {
        byte[] report = reportService.generateEmployeeReport(type);

        // Set headers for download
        HttpHeaders headers = new HttpHeaders();
        String filename = "employees." + type.name().toLowerCase();
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(type == ReportTypeEnum.PDF ? MediaType.APPLICATION_PDF : MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    }
}

