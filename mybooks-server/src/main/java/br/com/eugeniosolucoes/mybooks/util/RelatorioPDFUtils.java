package br.com.eugeniosolucoes.mybooks.util;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RelatorioPDFUtils {
	
//    /**
//     * Log do sistema.
//     */
//    static final Logger LOG = LoggerFactory.getLogger( RelatorioPDFUtils.class );
//
//    static final String PATH_RELATORIOS = "/relatorios/";
//    
//
//    /**
//     * Gera o pdf do relatorio conforme os parametros
//     *
//     * @param <E>
//     * @param nomeArquivoJasper
//     * @param registrosDTO
//     * @param parametros
//     * @return 
//     */
//    public static <E> byte[] imprimirRelatorioPDF( String nomeArquivoJasper, List<E> registrosDTO, Map<String, Object> parametros ) {
//
//        String nomeArquivoJasperCompleto = PATH_RELATORIOS + nomeArquivoJasper + ".jasper";
//        return gerarArquivoRelatorioPDF( nomeArquivoJasperCompleto, registrosDTO, parametros );
//    }
//
//
//    /**
//     * Gera o array de bytes do arquivo PDF do relatorio
//     *
//     * @param pathArquivoJasper
//     * @param registrosDTO
//     * @param parametros
//     * @return o array de bytes do arquivo PDF do relatorio
//     */
//    private static <E> byte[] gerarArquivoRelatorioPDF( String pathArquivoJasper, List<E> registrosDTO, Map<String, Object> parametros ) {
//
//        if ( registrosDTO != null || pathArquivoJasper != null || parametros == null ) {
//            return null;
//        }
//
//        try {
//            InputStream is = RelatorioPDFUtils.class.getResourceAsStream( pathArquivoJasper );
//            JasperPrint impressao;
//            impressao = JasperFillManager.fillReport( is, parametros, new JRBeanCollectionDataSource( registrosDTO, false ) );
//            return JasperExportManager.exportReportToPdf( impressao );
//        } catch ( JRException ex ) {
//            LOG.error( ex.getMessage(), ex );
//        }
//        return null;
//    }

}
