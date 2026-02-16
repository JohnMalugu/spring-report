package com.jcmlabs.spring_report.utils;

import com.jcmlabs.spring_report.enums.ReportTypeEnum;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;


import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Component
public class JasperReportsUtil {

    public byte[] exportJasperReportBytes(JasperPrint jasperPrint, ReportTypeEnum reportType) throws JRException {
        return switch (reportType) {
            case PDF -> JasperExportManager.exportReportToPdf(jasperPrint);
            case XLSX -> exportToXlsx(jasperPrint);
            default -> throw new IllegalArgumentException("Report type not supported: " + reportType);
        };
    }

    private byte[] exportToXlsx(JasperPrint jasperPrint) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRXlsxExporter exporter = new JRXlsxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

        // Excel specific configuration
        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setDetectCellType(true); // Keeps numbers as numbers, not text
        configuration.setCollapseRowSpan(false);
        configuration.setWhitePageBackground(false); // Removes white background for printing
        configuration.setRemoveEmptySpaceBetweenRows(true);

        exporter.setConfiguration(configuration);
        exporter.exportReport();

        return outputStream.toByteArray();
    }
}

