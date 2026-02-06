package com.jcmlabs.spring_report.service;

import com.jcmlabs.spring_report.dtos.EmployeeDto;
import com.jcmlabs.spring_report.utils.JasperReportsUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JasperReportsUtil jasperReportsUtil;

    public byte[] generateEmployeeReport(String fileType) throws Exception {
        List<EmployeeDto> data = employeeRepository.findAll()
                .stream()
                .map(e -> new EmployeeDto(e.getId(), e.getName(), e.getCity(), e.getSalary()))
                .toList();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("comanyName", "BLACK STAR TECHNOLOGIES");
        parameters.put("address", "HITEC City, Hyderabad");
        parameters.put("header", "Employees Salary Report");
        parameters.put("createdBy", "Your Name");
        parameters.put("logo", new FileInputStream(new File("src/main/resources/reports/logo.jpg")));

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        JasperReport jasperReport = JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:reports/emp24.jrxml").getAbsolutePath()
        );

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return jasperReportsUtil.exportJasperReportBytes(jasperPrint, ReportTypeEnum.valueOf(fileType));
    }
}

