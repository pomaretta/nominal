package persistence.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.*;
import net.sf.jasperreports.view.JasperViewer;
import persistence.Queries;
import service.Driver;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportAPI extends Driver {

    public ReportAPI(String url, String username, String password) throws SQLException {
        super(url, username, password);
    }

    @Override
    public Queries getQueries() {
        return null;
    }

    // PDF EXPORT
    public void exportToPdf(JasperReport report, HashMap<String,Object> parameters,String path) throws Exception {

        JRPdfExporter exporter = new JRPdfExporter();
        ExporterInput exporterInput = new SimpleExporterInput(getPrint(report,parameters));
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(path);
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();

        exporter.setExporterInput(exporterInput);
        exporter.setExporterOutput(exporterOutput);
        exporter.setConfiguration(configuration);

        exporter.exportReport();
    }

    // VIEWER
    public JasperViewer viewFromReport(JasperReport report, HashMap<String,Object> parameters) throws Exception {
        return new JasperViewer(getPrint(report,parameters),false);
    }

    // PRINT
    public JasperPrint getPrint(JasperReport report, HashMap<String,Object> parameters) throws JRException {
        return JasperFillManager.fillReport(report,parameters,this.connection);
    }

    // REPORT
    public JasperReport getReport(String path) throws IOException, JRException {
        return JasperCompileManager.compileReport(path);
    }

}
