package convertorExcel;

import javax.swing.ImageIcon;


public class Index extends javax.swing.JFrame {

    public Index() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/convertorExcel/images/icon.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelSeleccion = new javax.swing.JTabbedPane();
        DDJJ = new javax.swing.JPanel();
        btnGenerarDDJJ = new javax.swing.JButton();
        generarArchivoExcel = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        seleccionarArchivoDDJJ = new javax.swing.JLabel();
        textLoaderDDJJ = new javax.swing.JLabel();
        btnBuscarDDJJ = new javax.swing.JButton();
        direccionDDJJ = new javax.swing.JTextField();
        Empleados = new javax.swing.JPanel();
        seleccionarArchivoEmpleados = new javax.swing.JLabel();
        generarArchivoExcel1 = new javax.swing.JLabel();
        textLoaderEmp = new javax.swing.JLabel();
        nombre1 = new javax.swing.JLabel();
        btnGenerarEmp = new javax.swing.JButton();
        direccionEmp = new javax.swing.JTextField();
        btnBuscarEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setMinimumSize(new java.awt.Dimension(400, 200));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 200));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));

        panelSeleccion.setBackground(new java.awt.Color(51, 51, 51));
        panelSeleccion.setForeground(new java.awt.Color(255, 255, 255));

        DDJJ.setBackground(new java.awt.Color(51, 51, 51));
        DDJJ.setPreferredSize(new java.awt.Dimension(400, 200));

        btnGenerarDDJJ.setBackground(new java.awt.Color(153, 153, 153));
        btnGenerarDDJJ.setText("GENERAR");
        btnGenerarDDJJ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarDDJJ.setFocusPainted(false);
        btnGenerarDDJJ.setMaximumSize(new java.awt.Dimension(80, 25));
        btnGenerarDDJJ.setMinimumSize(new java.awt.Dimension(80, 25));
        btnGenerarDDJJ.setName(""); // NOI18N
        btnGenerarDDJJ.setPreferredSize(new java.awt.Dimension(80, 25));

        generarArchivoExcel.setForeground(new java.awt.Color(204, 204, 204));
        generarArchivoExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generarArchivoExcel.setText("Generar archivo Excel");
        generarArchivoExcel.setMaximumSize(new java.awt.Dimension(120, 15));
        generarArchivoExcel.setMinimumSize(new java.awt.Dimension(120, 15));
        generarArchivoExcel.setPreferredSize(new java.awt.Dimension(120, 15));

        nombre.setForeground(new java.awt.Color(204, 204, 204));
        nombre.setText("Nombre: ");

        seleccionarArchivoDDJJ.setForeground(new java.awt.Color(204, 204, 204));
        seleccionarArchivoDDJJ.setText("Seleccionar archivo de DDJJ");

        textLoaderDDJJ.setForeground(new java.awt.Color(213, 213, 213));
        textLoaderDDJJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnBuscarDDJJ.setBackground(new java.awt.Color(153, 153, 153));
        btnBuscarDDJJ.setText("Seleccionar");
        btnBuscarDDJJ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarDDJJ.setFocusPainted(false);
        btnBuscarDDJJ.setPreferredSize(new java.awt.Dimension(87, 25));

        direccionDDJJ.setEditable(false);
        direccionDDJJ.setBackground(new java.awt.Color(255, 255, 255));
        direccionDDJJ.setMinimumSize(new java.awt.Dimension(6, 25));
        direccionDDJJ.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout DDJJLayout = new javax.swing.GroupLayout(DDJJ);
        DDJJ.setLayout(DDJJLayout);
        DDJJLayout.setHorizontalGroup(
            DDJJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DDJJLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(generarArchivoExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(DDJJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DDJJLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(DDJJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textLoaderDDJJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seleccionarArchivoDDJJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DDJJLayout.createSequentialGroup()
                            .addComponent(btnBuscarDDJJ, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombre)
                            .addGap(2, 2, 2)
                            .addComponent(direccionDDJJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DDJJLayout.createSequentialGroup()
                            .addGap(0, 90, Short.MAX_VALUE)
                            .addComponent(btnGenerarDDJJ, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(90, 90, 90)))
                    .addGap(8, 8, 8)))
        );
        DDJJLayout.setVerticalGroup(
            DDJJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DDJJLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(generarArchivoExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(DDJJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DDJJLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seleccionarArchivoDDJJ)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(DDJJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(direccionDDJJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarDDJJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombre))
                    .addGap(39, 39, 39)
                    .addComponent(btnGenerarDDJJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textLoaderDDJJ, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelSeleccion.addTab("DDJJ", DDJJ);

        Empleados.setBackground(new java.awt.Color(51, 51, 51));

        seleccionarArchivoEmpleados.setForeground(new java.awt.Color(204, 204, 204));
        seleccionarArchivoEmpleados.setText("Seleccionar archivo de Empleaods");

        generarArchivoExcel1.setForeground(new java.awt.Color(204, 204, 204));
        generarArchivoExcel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generarArchivoExcel1.setText("Generar archivo Excel");
        generarArchivoExcel1.setMaximumSize(new java.awt.Dimension(120, 15));
        generarArchivoExcel1.setMinimumSize(new java.awt.Dimension(120, 15));
        generarArchivoExcel1.setPreferredSize(new java.awt.Dimension(120, 15));

        textLoaderEmp.setForeground(new java.awt.Color(213, 213, 213));
        textLoaderEmp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        nombre1.setForeground(new java.awt.Color(204, 204, 204));
        nombre1.setText("Nombre: ");

        btnGenerarEmp.setBackground(new java.awt.Color(153, 153, 153));
        btnGenerarEmp.setText("GENERAR");
        btnGenerarEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarEmp.setFocusPainted(false);
        btnGenerarEmp.setMaximumSize(new java.awt.Dimension(80, 25));
        btnGenerarEmp.setMinimumSize(new java.awt.Dimension(80, 25));
        btnGenerarEmp.setName(""); // NOI18N
        btnGenerarEmp.setPreferredSize(new java.awt.Dimension(80, 25));

        direccionEmp.setEditable(false);
        direccionEmp.setBackground(new java.awt.Color(255, 255, 255));
        direccionEmp.setMinimumSize(new java.awt.Dimension(6, 25));
        direccionEmp.setPreferredSize(new java.awt.Dimension(6, 25));

        btnBuscarEmp.setBackground(new java.awt.Color(153, 153, 153));
        btnBuscarEmp.setText("Seleccionar");
        btnBuscarEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarEmp.setFocusPainted(false);
        btnBuscarEmp.setPreferredSize(new java.awt.Dimension(87, 25));

        javax.swing.GroupLayout EmpleadosLayout = new javax.swing.GroupLayout(Empleados);
        Empleados.setLayout(EmpleadosLayout);
        EmpleadosLayout.setHorizontalGroup(
            EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadosLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(generarArchivoExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
            .addComponent(textLoaderEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EmpleadosLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(seleccionarArchivoEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmpleadosLayout.createSequentialGroup()
                            .addComponent(btnBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombre1)
                            .addGap(2, 2, 2)
                            .addComponent(direccionEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmpleadosLayout.createSequentialGroup()
                            .addGap(0, 90, Short.MAX_VALUE)
                            .addComponent(btnGenerarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(90, 90, 90)))
                    .addGap(8, 8, 8)))
        );
        EmpleadosLayout.setVerticalGroup(
            EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadosLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(generarArchivoExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(textLoaderEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EmpleadosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seleccionarArchivoEmpleados)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(direccionEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombre1))
                    .addGap(39, 39, 39)
                    .addComponent(btnGenerarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        panelSeleccion.addTab("Empleados", Empleados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DDJJ;
    private javax.swing.JPanel Empleados;
    public javax.swing.JButton btnBuscarDDJJ;
    public javax.swing.JButton btnBuscarEmp;
    public javax.swing.JButton btnGenerarDDJJ;
    public javax.swing.JButton btnGenerarEmp;
    public javax.swing.JTextField direccionDDJJ;
    public javax.swing.JTextField direccionEmp;
    private javax.swing.JLabel generarArchivoExcel;
    private javax.swing.JLabel generarArchivoExcel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre1;
    private javax.swing.JTabbedPane panelSeleccion;
    private javax.swing.JLabel seleccionarArchivoDDJJ;
    private javax.swing.JLabel seleccionarArchivoEmpleados;
    public javax.swing.JLabel textLoaderDDJJ;
    public javax.swing.JLabel textLoaderEmp;
    // End of variables declaration//GEN-END:variables
}
