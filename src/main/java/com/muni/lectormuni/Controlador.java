package com.muni.lectormuni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controlador implements ActionListener {

    private static Index view;
    public static File fileTxt = null;

    public Controlador(Index view) {
        Controlador.view = view;
        Controlador.view.btnBuscarDDJJ.addActionListener(this);
        Controlador.view.btnGenerarDDJJ.addActionListener(this);

        Controlador.view.btnBuscarEmp.addActionListener(this);
        Controlador.view.btnGenerarEmp.addActionListener(this);
    }

    public void iniciar() {
        Controlador.view.setTitle("Generador de excel");
        Controlador.view.setLocationRelativeTo(null);
        Controlador.view.setVisible(true);
        Controlador.view.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean archivoInvalido() {
        String tipoArchivo = "";
        try {
            tipoArchivo = Files.probeContentType(Controlador.fileTxt.toPath());
        } catch (Exception ex) {
            return true;
        }
        return (Controlador.fileTxt == null) || (!tipoArchivo.equals("text/plain"));
    }

    public void buscarArchivo() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int opcion = selectorArchivos.showOpenDialog(Controlador.view);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            Controlador.fileTxt = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

            if (archivoInvalido()) {
                Controlador.view.direccionDDJJ.setText("");
                JOptionPane.showMessageDialog(Controlador.view, "Archivo invalido", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
            } else {
                Controlador.view.direccionDDJJ.setText(Controlador.fileTxt.getName());
                Controlador.view.direccionEmp.setText(Controlador.fileTxt.getName());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //DECLARACIONES JURADAS
        
        // Buscar direccion
        if (ae.getSource() == Controlador.view.btnBuscarDDJJ) {
            buscarArchivo();
        }

        // Generar Excel
        if (ae.getSource() == Controlador.view.btnGenerarDDJJ) {
            if (archivoInvalido()) {
                JOptionPane.showMessageDialog(Controlador.view, "Seleccione un archivo de DDJJ", "Error al leer", JOptionPane.ERROR_MESSAGE);
            } else {
                WorkerDDJJ worker = new WorkerDDJJ(view);
                worker.execute();
            }
        }

        // EMPLEADOS
        
        // Buscar direccion
        if (ae.getSource() == Controlador.view.btnBuscarEmp) {
            buscarArchivo();
        }

        // Generar Excel
        if (ae.getSource() == Controlador.view.btnGenerarEmp) {
            if (archivoInvalido()) {
                JOptionPane.showMessageDialog(Controlador.view, "Seleccione un archivo de Empleados", "Error al leer", JOptionPane.ERROR_MESSAGE);
            } else {
                WorkerEmpleados worker = new WorkerEmpleados(view);
                worker.execute();
            }
        }
    }
}
