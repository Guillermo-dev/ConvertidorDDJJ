package convertorDDJJ;

public class LectorMain {

    public static void main(String[] args) {
        Index view = new Index();

        Controlador controlador = new Controlador(view);
        controlador.iniciar();
    }
}
