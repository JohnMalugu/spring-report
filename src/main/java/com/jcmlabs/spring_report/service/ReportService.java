package com.jcmlabs.spring_report.service;

import com.jcmlabs.spring_report.dtos.EmployeeDto;
import com.jcmlabs.spring_report.enums.ReportTypeEnum;
import com.jcmlabs.spring_report.repositories.EmployeeRepository;
import com.jcmlabs.spring_report.utils.JasperReportsUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportService {

    private final EmployeeRepository employeeRepository;
    private final JasperReportsUtil jasperReportsUtil;

    // Cache the compiled report to avoid recompiling on every request
    private JasperReport cachedJasperReport;

    @PostConstruct
    public void init() {
        // Pre-compile the report at startup
        try {
            ClassPathResource reportResource = new ClassPathResource("templates/emp24.jrxml");
            try (InputStream inputStream = reportResource.getInputStream()) {
                this.cachedJasperReport = JasperCompileManager.compileReport(inputStream);
            }
            log.info("Jasper Report compiled successfully.");
        } catch (Exception e) {
            log.error("Failed to compile Jasper Report", e);
            throw new RuntimeException("Could not compile report template", e);
        }
    }

    public byte[] generateEmployeeReport(ReportTypeEnum reportType) throws JRException, IOException {
        log.info("Preparing to generate {} report", reportType);

        // Fetch data (Consider Spring Data Projections if this list gets large)
        List<EmployeeDto> data = employeeRepository.findAll()
                .stream()
                .map(e -> new EmployeeDto(e.getId(), e.getUuid(), e.getName(), e.getCity(), e.getSalary()))
                .toList();

        // Load logo safely from Classpath
        ClassPathResource imgResource = new ClassPathResource("reports/logo.jpg");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("comanyName", "JCMLabs | Digital Innovations");
        parameters.put("address", "HITEC City, Hyderabad");
        parameters.put("header", "Employees Salary Report");
        parameters.put("createdBy", "System Admin");
        // Pass InputStream, not File, for images in JARs
        parameters.put("logo", imgResource.getInputStream());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

        log.info("Filling report...");
        JasperPrint jasperPrint = JasperFillManager.fillReport(cachedJasperReport, parameters, dataSource);

        return jasperReportsUtil.exportJasperReportBytes(jasperPrint, reportType);
    }
}