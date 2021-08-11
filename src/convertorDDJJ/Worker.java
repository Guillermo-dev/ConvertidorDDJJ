package convertorDDJJ;

import java.util.ArrayList;
import javax.swing.SwingWorker;

// Clase para ejecutar tareas en segundo plano, en otro hilo

public class Worker extends SwingWorker<Void, Void> {

    private final Index view;

    public Worker(Index view) {
        this.view = view;
    }

    @Override
    protected Void doInBackground() throws Exception {
        ArrayList<String[]> data = new ArrayList<>();
        Controlador.generarTablas(data);
        Controlador.generarExcel(data);
        return null;
    }

    @Override
    protected void done() {
        this.view.btnBuscar.setEnabled(true);
        this.view.btnGenerar.setEnabled(true);
        this.view.textIndicador.setText("Excel generado con exito");
    }
}
