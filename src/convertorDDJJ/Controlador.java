package convertorDDJJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controlador implements ActionListener {

    private static Index view;
    public static File DDJJFileTxt = null;

    public Controlador(Index view) {
        Controlador.view = view;
        Controlador.view.btnBuscar.addActionListener(this);
        Controlador.view.btnGenerar.addActionListener(this);
    }

    public void iniciar() {
        Controlador.view.setTitle("Generador de excel DDJJ");
        Controlador.view.setLocationRelativeTo(null);
        Controlador.view.setVisible(true);
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean archivoInvalido() {
        String tipoArchivo = "";
        try {
            tipoArchivo = Files.probeContentType(Controlador.DDJJFileTxt.toPath());
        } catch (Exception ex) {
            return true;
        }
        return (Controlador.DDJJFileTxt == null) || (!tipoArchivo.equals("text/plain"));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // BUSCAR DIRECCION
        if (ae.getSource() == Controlador.view.btnBuscar) {
            JFileChooser selectorArchivos = new JFileChooser();
            selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int opcion = selectorArchivos.showOpenDialog(Controlador.view);

            if (opcion == JFileChooser.APPROVE_OPTION) {

                Controlador.DDJJFileTxt = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

                if (archivoInvalido()) {
                    Controlador.view.direccion.setText("");
                    JOptionPane.showMessageDialog(Controlador.view, "Archivo invalido", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
                } else {
                    Controlador.view.direccion.setText(Controlador.DDJJFileTxt.getName());
                }
            }
        }

        // GENERAR EXCEL
        if (ae.getSource() == Controlador.view.btnGenerar) {
            if (archivoInvalido()) {
                JOptionPane.showMessageDialog(this.view, "Seleccione un archivo de DDJJ", "Error al leer", JOptionPane.ERROR_MESSAGE);
            } else {
                Worker worker = new Worker(view);
                worker.execute();
            }
        }
    }
}
