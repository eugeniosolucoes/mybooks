package br.com.eugeniosolucoes.mybooks.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RelatorioPDFUtils {

    /**
     * Log do sistema.
     */
    static final Logger LOG = LoggerFactory.getLogger( RelatorioPDFUtils.class );

    static final String PATH_RELATORIOS = "/relatorios/";

    /**
     * Gera o pdf do relatorio conforme os parametros
     *
     * @param <E>
     * @param nomeArquivoJasper
     * @param registrosDTO
     * @param parametros
     * @return
     */
    public static <E> byte[] imprimirRelatorioPDF( String nomeArquivoJasper, List<E> registrosDTO ) {

        String nomeArquivoJasperCompleto = PATH_RELATORIOS + nomeArquivoJasper + ".jrxml";
        return gerarArquivoRelatorioPDF( nomeArquivoJasperCompleto, registrosDTO );
    }

    /**
     * Gera o array de bytes do arquivo PDF do relatorio
     *
     * @param pathArquivoJasper
     * @param registrosDTO
     * @param parametros
     * @return o array de bytes do arquivo PDF do relatorio
     */
    private static <E> byte[] gerarArquivoRelatorioPDF( String pathArquivoJasper, List<E> registrosDTO ) {

        if ( registrosDTO == null || pathArquivoJasper == null ) {
            return null;
        }

        try {

            final InputStream stream = RelatorioPDFUtils.class.getResourceAsStream( pathArquivoJasper );

            // Compile the Jasper report from .jrxml to .japser
            final JasperReport report = JasperCompileManager.compileReport( stream );

            // Fetching the employees from the data source.
            final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource( registrosDTO );

            // Adding the additional parameters to the pdf.
            final Map<String, Object> parameters = new HashMap<>();

            // Filling the report with the employee data and additional parameters information.
            final JasperPrint print = JasperFillManager.fillReport( report, parameters, source );

            // Users can change as per their project requrirements or can take it as request input requirement.
            // For simplicity, this tutorial will automatically place the file under the "c:" drive.
            // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.
            final String filePath = "\\";
            // Export the report to a PDF file.
            return JasperExportManager.exportReportToPdf( print );

        } catch ( JRException ex ) {
            LOG.error( ex.getMessage(), ex );
        }
        return null;
    }
}
