package controladores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.VentanaPrincipal;

public class ControladorRegistro implements ActionListener {
    private VentanaPrincipal vista;

    public ControladorRegistro(VentanaPrincipal vista) {
        this.vista = vista;
        // Le decimos al botón que este controlador escuchará sus clics
        this.vista.getBotonAsociar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Este método se ejecuta AUTOMÁTICAMENTE cuando se hace clic
        if (e.getSource() == vista.getBotonAsociar()) {
            vista.registrarVehiculo();
        }
    }
}