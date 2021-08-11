package convertorDDJJ;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Controlador implements ActionListener {

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

    private static Index view;
    private static File DDJJFileTxt = null;

    public Controlador(Index view) {
        Controlador.view = view;
        Controlador.view.btnBuscar.addActionListener(this);
        Controlador.view.btnGenerar.addActionListener(this);
    }

    public void iniciar() {
        this.view.setTitle("Generador de excel DDJJ");
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    public boolean archivoInvalido() {
        String tipoArchivo = "";
        try {
            tipoArchivo = Files.probeContentType(this.DDJJFileTxt.toPath());
        } catch (Exception ex) {
        }
        return (this.DDJJFileTxt == null) || (!tipoArchivo.equals("text/plain"));
    }

    public static void generarTablas(ArrayList<String[]> data) {
        //Contenido de la hoja de excel

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(Controlador.DDJJFileTxt);
            br = new BufferedReader(fr);
            // Lectura del fichero
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
            }
        } catch (Exception e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void generarExcel(ArrayList<String[]> data) {
        String fileName = "DDJJ.xlsx";
        String filePath = Controlador.DDJJFileTxt.getPath() + fileName;

        //Creando objeto libro de Excel
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet hoja = book.createSheet("Declaraciones juradas");

        int i = 0;
        for (String[] declaracion : data) {
            XSSFRow row = hoja.createRow(i);//se crea las filas
            for (int j = 0; j < HEADER.length; j++) {
                XSSFCell cell = row.createCell(j);//Creando celda para el contenido del producto
                cell.setCellValue(declaracion[j]); //Añadiendo el contenido
            }
            i++;
        }
        for (i = 0; i < HEADER.length; i++) {
            hoja.autoSizeColumn(i);
        }

        File excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear
        try (FileOutputStream fileOuS = new FileOutputStream(excelFile)) {
            if (excelFile.exists()) { // Si el archivo existe lo eliminaremos
                excelFile.delete();
            }
            book.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();

            Desktop.getDesktop().open(excelFile);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(Controlador.view, "Error inesperado", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        // BUSCAR DIRECCION
        if (ae.getSource() == Controlador.view.btnBuscar) {
            JFileChooser selectorArchivos = new JFileChooser();
            selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            int resultado = selectorArchivos.showOpenDialog(Controlador.view);

            Controlador.DDJJFileTxt = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

            if (archivoInvalido()) {
                JOptionPane.showMessageDialog(Controlador.view, "Archivo invalido", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
            } else {
                Controlador.view.direccion.setText(Controlador.DDJJFileTxt.getName());
            }
        }

        // GENERAR EXCEL
        if (ae.getSource() == Controlador.view.btnGenerar) {
            if (archivoInvalido()) {
                JOptionPane.showMessageDialog(Controlador.view, "Archivo invalido", "Seleccionar Archivo", JOptionPane.ERROR_MESSAGE);
            } else {
                Controlador.view.btnBuscar.setEnabled(false);
                Controlador.view.btnGenerar.setEnabled(false);
                
                Controlador.view.textIndicador.setText("Generando archivo excel, por favor no cierre el programa");
                
                Worker worker = new Worker(view);
                worker.execute();
            }
        }
    }
}
