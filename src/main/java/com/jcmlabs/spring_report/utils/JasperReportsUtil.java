package com.jcmlabs.spring_report.utils;

import com.jcmlabs.spring_report.enums.ReportTypeEnum;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

import static org.apache.poi.hpsf.ClassIDPredefined.PDF;

@Component
public class JasperReportsUtil {

    public byte[] exportJasperReportBytes(JasperPrint jasperPrint, ReportTypeEnum reportType) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        switch (reportType) {
            case XLSX -> {
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                exporter.exportReport();
            }
            case DOC -> {
                JRRtfExporter exporter = new JRRtfExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
                exporter.exportReport();
            }
            case PDF -> JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            default -> throw new IllegalArgumentException("Unsupported format");
        }
        return outputStream.toByteArray();
    }
}

