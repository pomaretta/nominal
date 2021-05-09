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

    /**
     *
     * Report API to create reports from JasperSoft reports.
     *
     * @param url the url of the database.
     * @param username the username.
     * @param password the password.
     * @throws SQLException if something fails.
     */
    public ReportAPI(String url, String username, String password) throws SQLException {
        super(url, username, password);
    }

    @Override
    public Queries getQueries() {
        return null;
    }

    // PDF EXPORT

    /**
     *
     * Export created PDF to desired path.
     *
     * @param report JasperReport to export.
     * @param parameters the desired parameters.
     * @param path the path to export.
     * @throws Exception if something of JasperReport fails.
     */
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

    /**
     *
     * Get the view of the desired report.
     *
     * @param report the JasperReport report.
     * @param parameters the desired parameters.
     * @return a JasperViewer to show it in the right moment.
     * @throws Exception if something of JasperReport fails.
     */
    public JasperViewer viewFromReport(JasperReport report, HashMap<String,Object> parameters) throws Exception {
        return new JasperViewer(getPrint(report,parameters),false);
    }

    // PRINT

    /**
     *
     * Get the print of an specified report and fill it with the api connection.
     *
     * @param report the report to fill.
     * @param parameters the desired parameters.
     * @return a JasperPrint object.
     * @throws JRException if something of JasperReport fails.
     */
    public JasperPrint getPrint(JasperReport report, HashMap<String,Object> parameters) throws JRException {
        return JasperFillManager.fillReport(report,parameters,this.connection);
    }

    // REPORT

    /**
     *
     * Get a report from file in path.
     *
     * @param path the path to file.
     * @return a JasperReport.
     * @throws IOException if the file occurs in an error.
     * @throws JRException if something of JasperReport fails.
     */
    public JasperReport getReport(String path) throws IOException, JRException {
        return JasperCompileManager.compileReport(path);
    }

}
