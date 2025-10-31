package vistas;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelCuenta extends JPanel {
    private JPanel panelContenido, panelCuenta, panelVehiculo, panelComprobante;
    private JLabel labelUsuario, labelMarca, labelModelo, labelPatente, labelColor;
    // private JComboBox<UsuarioUTN> cbUsuarios;
    private JTextField tfMarca, tfModelo, tfPatente, tfColor;
    private JButton btnVerificar, btnRegistrar, btnEliminar, btnImprimir;

    // public PanelCuenta(ArrayList<UsuarioUTN> usuarios) {

    public PanelCuenta() {
        setPreferredSize(new Dimension(0, 40));
        setBorder(BorderFactory.createTitledBorder("Datos de la cuenta"));

        // inicializarComponentes(usuarios);
        inicializarComponentes();

        configurarLayout();
    }

    // Getter
    public JButton getBtnVerificar() {
        return btnRegistrar;
    }

    // Métodos
    // private void inicializarComponentes(ArrayList<UsuarioUTN> usuarios) {

    private void inicializarComponentes() {

        labelUsuario = new JLabel("Usuario");

        btnVerificar = new JButton("Verificar cuenta");

        // cbUsuarios = new JComboBox<>();
        // for (UsuarioUTN usuario : usuarios) {
        // cbUsuarios.addItem(usuario);
        // }
        // cbUsuarios.setEditable(true);
        // cbUsuarios.setSelectedIndex(-1);
        // JTextField tfEditorComboC = (JTextField)
        // cbUsuarios.getEditor().getEditorComponent();
        // tfEditorComboC.addKeyListener(new KeyAdapter() {
        // @Override
        // public void keyReleased(KeyEvent e) {
        // String texto = tfEditorComboC.getText().toLowerCase();
        // cbUsuarios.hidePopup(); // Ocultar temporalmente
        // cbUsuarios.removeAllItems();
        // for (UsuarioUTN usuario : usuarios) {
        // if (usuario.toString().toLowerCase().contains(texto)) {
        // cbUsuarios.addItem(usuario);
        // }
        // }
        // cbUsuarios.getEditor().setItem(texto);
        // cbUsuarios.showPopup();
        // }
        // });

    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelUsuario, gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // add(cbUsuarios, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnVerificar, gbc);
    }
}
