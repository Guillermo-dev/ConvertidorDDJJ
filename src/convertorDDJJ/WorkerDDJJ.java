package convertorDDJJ;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

// Clase para ejecutar tareas en segundo plano, en otro hilo
public class WorkerDDJJ extends SwingWorker<Void, String> {

    private final Index view;

    private static final int CUIT = 0;
    private static final int DDJJ_ORIGEN = 1;
    private static final int OTRA = 2;
    private static final int CUJ = 3;
    private static final int TOTAL_PAIS = 4;
    private static final int ANIO = 5;
    private static final int PERIODO = 6;
    private static final int RECTIFICACION = 7;
    private static final int FECHA_PRES = 8;
    private static final int TOTAL_IMP_LIQ = 9;
    private static final int SALDO_PER_ANT = 10;
    private static final int RETENCIONES = 11;
    private static final int PERCEPCIONES = 12;
    private static final int RETENCIONES_BANCARIAS = 13;
    private static final int OTROS_PAGOS = 14;
    private static final int IMP_A_PAGAR_SALDO = 15;
    private static final int IMP_GRABADO = 16;
    private static final int IMP_NO_GRABADO = 17;
    private static final int IMP_EXENTO = 18;
    private static final String[] HEADER = new String[]{"CUIT", "DDJJ origen", "", "CUJ", "Total pais", "Año", "Periodo", "Rectificacion", "Fecha Presentacion", "Total impuesto liquidados", "Saldo periodo anterior", "Retenciones", "Percepciones", "Retenciones bancarias", "Otros pagos", "Importe a pagar saldo", "Importe gravado", "Importe no gravado", "Importe exento"};

    public WorkerDDJJ(Index view) {
        this.view = view;
    }

    @Override
    protected void process(List<String> loader) {
        // Actualizacion de loader
        this.view.textLoaderDDJJ.setText(loader.get(loader.size() - 1));
    }

    @Override
    protected Void doInBackground() throws Exception {
        this.view.btnBuscarDDJJ.setEnabled(false);
        this.view.btnGenerarDDJJ.setEnabled(false);

        ArrayList<String[]> data = new ArrayList<>();

        // LECTURA DE TXT Y CREACION DE ARRAY DE DATA
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(Controlador.fileTxt);
            br = new BufferedReader(fr);
            String linea;
            String prevCUILT = "";
            while ((linea = br.readLine()) != null) {
                String[] fila = new String[19];
                if (!prevCUILT.equals(linea.substring(0, 11))) {
                    String[] espacio = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
                    data.add(espacio);
                    data.add(HEADER);
                }
                fila[CUIT] = linea.substring(0, 11);
                fila[DDJJ_ORIGEN] = linea.substring(11, 12);
                fila[OTRA] = linea.substring(12, 22);
                fila[CUJ] = linea.substring(22, 32);
                fila[TOTAL_PAIS] = linea.substring(32, 51);
                fila[ANIO] = linea.substring(51, 55);
                fila[PERIODO] = linea.substring(55, 57);
                fila[RECTIFICACION] = linea.substring(57, 59);
                fila[FECHA_PRES] = linea.substring(59, 63) + "-" +linea.substring(63, 65) +"-"+linea.substring(65, 67);
                fila[TOTAL_IMP_LIQ] = linea.substring(67, 86);
                fila[SALDO_PER_ANT] = linea.substring(86, 105);
                fila[RETENCIONES] = linea.substring(105, 124);
                fila[PERCEPCIONES] = linea.substring(124, 143);
                fila[RETENCIONES_BANCARIAS] = linea.substring(143, 162);
                fila[OTROS_PAGOS] = linea.substring(162, 181);
                fila[IMP_A_PAGAR_SALDO] = linea.substring(181, 200);
                fila[IMP_GRABADO] = linea.substring(200, 219);
                fila[IMP_NO_GRABADO] = linea.substring(219, 238);
                fila[IMP_EXENTO] = linea.substring(238, 257);

                data.add(fila);
                prevCUILT = linea.substring(0, 11);
                publish("Leyendo Declaraciones juradas " + data.size());
            }
        } catch (IOException e) {
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e2) {
            }
        }

        // ESCRITURA DE FILAS Y CREACION DE EXCEL
        String fileName = "DDJJ.xlsx";
        String filePath = Controlador.fileTxt.getPath() + fileName;

        //Creando objeto libro de Excel
        SXSSFWorkbook book = new SXSSFWorkbook();
        SXSSFSheet hoja = book.createSheet("Declaraciones juradas");

        int i = 0;
        for (String[] declaracion : data) {
            SXSSFRow row = hoja.createRow(i);// Se crea las filas
            if (i == 0) {
                hoja.setColumnWidth(CUIT, 4000);
                hoja.setColumnWidth(DDJJ_ORIGEN, 2500);
                hoja.setColumnWidth(OTRA, 3500);
                hoja.setColumnWidth(CUJ, 3500);
                hoja.setColumnWidth(TOTAL_PAIS, 7000);
                hoja.setColumnWidth(ANIO, 3000);
                hoja.setColumnWidth(PERIODO, 3000);
                hoja.setColumnWidth(RECTIFICACION, 3000);
                hoja.setColumnWidth(FECHA_PRES, 4500);
                hoja.setColumnWidth(TOTAL_IMP_LIQ, 7000);
                hoja.setColumnWidth(SALDO_PER_ANT, 7000);
                hoja.setColumnWidth(RETENCIONES, 7000);
                hoja.setColumnWidth(PERCEPCIONES, 7000);
                hoja.setColumnWidth(RETENCIONES_BANCARIAS, 7000);
                hoja.setColumnWidth(OTROS_PAGOS, 7000);
                hoja.setColumnWidth(IMP_A_PAGAR_SALDO, 7000);
                hoja.setColumnWidth(IMP_GRABADO, 7000);
                hoja.setColumnWidth(IMP_NO_GRABADO, 7000);
                hoja.setColumnWidth(IMP_EXENTO, 7000);
            }
            for (int j = 0; j < HEADER.length; j++) {
                SXSSFCell cell = row.createCell(j);// Se crea la celda 
                cell.setCellValue(declaracion[j]); // Se añade el contenido
            }

            publish("Generando Excel (" + i + " / " + data.size() + ")");
            i++;
        }

        publish("Ya casi estamos, ultimos detalles");

        File excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear
        try (FileOutputStream fileOuS = new FileOutputStream(excelFile)) {
            if (excelFile.exists()) { // Si el archivo existe lo eliminaremos
                excelFile.delete();
            }
            book.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();

            this.view.textLoaderDDJJ.setText("Excel generado con exito");
            Desktop.getDesktop().open(excelFile);
        } catch (Exception e) {
            this.view.textLoaderDDJJ.setText("");
            JOptionPane.showMessageDialog(this.view, "Error inesperado, vuelve a intentarlo", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    @Override
    protected void done() {
        this.view.btnBuscarDDJJ.setEnabled(true);
        this.view.btnGenerarDDJJ.setEnabled(true);
    }
}
