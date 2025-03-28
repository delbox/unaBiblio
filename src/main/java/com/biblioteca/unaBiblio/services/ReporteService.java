/*package com.biblioteca.unaBiblio.services;

import com.biblioteca.unaBiblio.models.PrestamoLibro;
import com.biblioteca.unaBiblio.repositories.PrestamoLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private PrestamoLibroRepository prestamoLibroRepository;

    public byte[] generarReportePrestamos(String formato) throws Exception {
        List<PrestamoLibro> prestamos = prestamoLibroRepository.findAll();

        if (formato.equalsIgnoreCase("pdf")) {
            return generarReportePDF(prestamos);
        } else if (formato.equalsIgnoreCase("excel")) {
            return generarReporteExcel(prestamos);
        } else {
            throw new IllegalArgumentException("Formato no soportado: " + formato);
        }
    }

    private byte[] generarReportePDF(List<PrestamoLibro> prestamos) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Usando iText para generar PDF
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Reporte de Préstamos de Libros").setBold().setFontSize(14));

        Table table = new Table(new float[]{1, 3, 3, 3, 3, 3}); // Ancho relativo de las 5 columnas
        table.setWidth(300); // Ancho de la tabla

        table.addCell("ID");
        table.addCell("Libro");
        table.addCell("Bibliotecario");
        table.addCell("Alumno");
        table.addCell("Fecha Préstamo");
        table.addCell("Fecha Devolución");

        for (PrestamoLibro prestamo : prestamos) {
            table.addCell(String.valueOf(prestamo.getIdPrestamo()));
            table.addCell(prestamo.getLibro().getDescripcion());
            table.addCell((prestamo.getBibliotecario().getNombre()) + " " + (prestamo.getBibliotecario().getApellido()));
            table.addCell((prestamo.getAlumno().getNombre()) + " "  + (prestamo.getAlumno().getApellido()));
            table.addCell(prestamo.getFechaPrestamo().toString());
            table.addCell(prestamo.getFechaEstimadaDevolucion().toString());
        }

        document.add(table);
        document.close();

        return out.toByteArray();
    }

    private byte[] generarReporteExcel(List<PrestamoLibro> prestamos) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Préstamos de Libros");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Libro");
        header.createCell(2).setCellValue("Bibliotecario");
        header.createCell(3).setCellValue("Alumno");
        header.createCell(4).setCellValue("Fecha Préstamo");
        header.createCell(5).setCellValue("Fecha Devolución");

        int rowIdx = 1;
        for (PrestamoLibro prestamo : prestamos) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(prestamo.getIdPrestamo());
            row.createCell(1).setCellValue(prestamo.getLibro().getDescripcion());
            row.createCell(2).setCellValue(prestamo.getBibliotecario().getNombre());
            row.createCell(3).setCellValue(prestamo.getBibliotecario().getNombre());
            row.createCell(4).setCellValue(prestamo.getFechaPrestamo().toString());
            row.createCell(5).setCellValue(prestamo.getFechaEstimadaDevolucion().toString());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }
}
*/
