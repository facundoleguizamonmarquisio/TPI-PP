package vistas;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import modelos.UsuarioUTN;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelCuenta extends JPanel {
    private JLabel labelUsuario;
    private JComboBox<String> cbUsuarios;
    private JButton btnVerificar;
    private JLabel lblMensajeVerificacion;
    private List<String> documentoUsuarios;

    public PanelCuenta(List<String> documentoUsuarios) {
        this.documentoUsuarios = documentoUsuarios;

        setBorder(BorderFactory.createTitledBorder("Datos de la cuenta"));

        inicializarComponentes();

        configurarLayout();
    }

    // Setter
    public void setCbUsuarios() {
        for (String documento : documentoUsuarios) {
            cbUsuarios.addItem(documento);
        }
        cbUsuarios.setEditable(true);
        cbUsuarios.setSelectedIndex(-1);
        JTextField tfEditorComboC = (JTextField) cbUsuarios.getEditor().getEditorComponent();
        tfEditorComboC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = tfEditorComboC.getText().toLowerCase();
                cbUsuarios.hidePopup(); // Ocultar temporalmente
                cbUsuarios.removeAllItems();
                for (String documento : documentoUsuarios) {
                    if (documento.toString().toLowerCase().contains(texto)) {
                        cbUsuarios.addItem(documento);
                    }
                }
                cbUsuarios.getEditor().setItem(texto);
                cbUsuarios.showPopup();
            }
        });
    }
        public void mostrarLblVerificar(String mensaje) {
        lblMensajeVerificacion.setText(mensaje);
    }
    // Getter
    public JButton getBtnVerificar() {
        return btnVerificar;
    }

    public JComboBox<String> getCbUsuarios() {
        return cbUsuarios;
    }

    // Métodos
    private void inicializarComponentes() {

        labelUsuario = new JLabel("DNI (Usuario)");

        btnVerificar = new JButton("Verificar cuenta");

        cbUsuarios = new JComboBox<>();

        lblMensajeVerificacion = new JLabel();

    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(cbUsuarios, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnVerificar, gbc);

        gbc.gridy = 3; // debajo del botón
        add(lblMensajeVerificacion, gbc);  

        setMinimumSize(getPreferredSize());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
    }
}
