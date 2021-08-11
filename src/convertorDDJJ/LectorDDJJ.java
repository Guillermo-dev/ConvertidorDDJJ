package convertorDDJJ;

public class LectorDDJJ {

    public static void main(String[] args) {
        Index view = new Index();

        Controlador controlador = new Controlador(view);
        controlador.iniciar();
    }
}
