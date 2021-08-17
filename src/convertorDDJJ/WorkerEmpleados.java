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
public class WorkerEmpleados extends SwingWorker<Void, String> {

    private final Index view;

    private static final int CUIT = 0;
    private static final int ANIO = 1;
    private static final int PERIODO = 2;
    private static final int FECHA_PRESEN = 3;
    private static final int CANT_EMPLEAS = 4;

    private static final String[] HEADER = new String[]{"CUIT", "Año", "Periodo", "Fecha presentacion", "Cantidad empleados"};

    public WorkerEmpleados(Index view) {
        this.view = view;
    }

    @Override
    protected void process(List<String> loader) {
        // Actualizacion de loader
        this.view.textLoaderEmp.setText(loader.get(loader.size() - 1));
    }

    @Override
    protected Void doInBackground() throws Exception {
        this.view.btnBuscarEmp.setEnabled(false);
        this.view.btnGenerarEmp.setEnabled(false);

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
                fila[ANIO] = linea.substring(11, 15);
                fila[PERIODO] = linea.substring(15, 17);
                fila[FECHA_PRESEN] = linea.substring(17, 25);
                fila[CANT_EMPLEAS] = linea.substring(25, 31);

                data.add(fila);
                prevCUILT = linea.substring(0, 11);
                
                publish("Leyendo Empleados " + data.size());
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
        String fileName = "Empleados.xlsx";
        String filePath = Controlador.fileTxt.getPath() + fileName;

        //Creando objeto libro de Excel
        SXSSFWorkbook book = new SXSSFWorkbook();
        SXSSFSheet hoja = book.createSheet("Empleados");

        int i = 0;
        for (String[] declaracion : data) {
            SXSSFRow row = hoja.createRow(i);// Se crea las filas
            if (i == 0) {
                hoja.setColumnWidth(CUIT, 4000);
                hoja.setColumnWidth(ANIO, 3000);
                hoja.setColumnWidth(PERIODO, 3000);
                hoja.setColumnWidth(FECHA_PRESEN, 7000);
                hoja.setColumnWidth(CANT_EMPLEAS, 6000);
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
        this.view.btnBuscarEmp.setEnabled(true);
        this.view.btnGenerarEmp.setEnabled(true);
    }
}
