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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Clase para ejecutar tareas en segundo plano, en otro hilo
public class Worker extends SwingWorker<Void, String> {

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

    public Worker(Index view) {
        this.view = view;
    }

    @Override
    protected void process(List<String> loader) {
        // Actualizacion de loader
        this.view.textLoader.setText(loader.get(loader.size() - 1));
    }

    @Override
    protected Void doInBackground() throws Exception {
        this.view.btnBuscar.setEnabled(false);
        this.view.btnGenerar.setEnabled(false);

        ArrayList<String[]> data = new ArrayList<>();

        // LECTURA DE TXT Y CREACION DE ARRAY DE DATA
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(Controlador.DDJJFileTxt);
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
                fila[FECHA_PRES] = linea.substring(59, 67);
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
        String filePath = Controlador.DDJJFileTxt.getPath() + fileName;

        //Creando objeto libro de Excel
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet hoja = book.createSheet("Declaraciones juradas");

        int i = 0;
        for (String[] declaracion : data) {
            XSSFRow row = hoja.createRow(i);// Se crea las filas
            for (int j = 0; j < HEADER.length; j++) {
                XSSFCell cell = row.createCell(j);// Se crea la celda 
                cell.setCellValue(declaracion[j]); // Se añade el contenido
            }
            if (i == 2) {
                for (int x = 0; x < HEADER.length; x++) {
                    hoja.autoSizeColumn(x);
                }
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

            this.view.textLoader.setText("Excel generado con exito");
            Desktop.getDesktop().open(excelFile);
        } catch (Exception e) {
            this.view.textLoader.setText("");
            JOptionPane.showMessageDialog(this.view, "Error inesperado, vuelve a intentarlo", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    @Override
    protected void done() {
        this.view.btnBuscar.setEnabled(true);
        this.view.btnGenerar.setEnabled(true);
    }
}
