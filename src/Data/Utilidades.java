package Data;

import javax.swing.JFrame;

/**
 *
 * @author eefre
 */
public class Utilidades {

    private static final java.util.List<JFrame> ventanasAbiertas = new java.util.ArrayList<>();

    public static void abrirNuevaVentana(JFrame nuevaVentana) {
        // Cierra todas las ventanas abiertas excepto la nueva que se va a abrir
        cerrarTodasLasVentanas();

        // Agrega la nueva ventana a la lista de ventanas abiertas
        ventanasAbiertas.add(nuevaVentana);

        // Hace visible la nueva ventana
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.setVisible(true);
    }

    public static void cerrarTodasLasVentanas() {
        // Cierra todas las ventanas abiertas
        for (JFrame ventana : ventanasAbiertas) {
            if (ventana != null && ventana.isVisible()) {
                ventana.dispose();
            }
        }
        // Limpia la lista de ventanas abiertas
        ventanasAbiertas.clear();
    }
}
