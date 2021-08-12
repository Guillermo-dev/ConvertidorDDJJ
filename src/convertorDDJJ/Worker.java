package convertorDDJJ;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;

// Clase para ejecutar tareas en segundo plano, en otro hilo
public class Worker extends SwingWorker<Void, String> {

    private final Index view;

    public Worker(Index view) {
        this.view = view;
    }

    protected void process(List<String> loader) {
        this.view.textIndicador.setText(loader.get(loader.size() - 1)); // The last value in this array is all we care about.
        System.out.println(loader.get(loader.size() - 1));
    }

    @Override
    protected Void doInBackground() throws Exception {
        publish("Leyendo DDJJ");
        ArrayList<String[]> data = new ArrayList<>();
        Controlador.generarTablas(data);
        publish("Creando excel");
        Controlador.generarExcel(data);
        return null;
    }

    @Override
    protected void done() {
        this.view.btnBuscar.setEnabled(true);
        this.view.btnGenerar.setEnabled(true);
    }
}
