package vistas;

//
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelBuscarCuenta extends JPanel {
    private List<String> legajoUsuarios;
    private JLabel labelUsuario;
    private JComboBox<String> cbUsuarios;
    private JButton btnBuscar;

    public PanelBuscarCuenta(List<String> legajoUsuarios) {
        this.legajoUsuarios = legajoUsuarios;

        setBorder(BorderFactory.createTitledBorder("Buscar cuenta"));

        inicializarComponentes();

        configurarLayout();
    }

    // Setter
    public void setCbUsuarios() {
        for (String legajo : legajoUsuarios) {
            cbUsuarios.addItem(legajo);
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
                for (String legajo : legajoUsuarios) {
                    if (legajo.toString().toLowerCase().contains(texto)) {
                        cbUsuarios.addItem(legajo);
                    }
                }
                cbUsuarios.getEditor().setItem(texto);
                cbUsuarios.showPopup();
            }
        });
    }

    // Getter
    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JComboBox<String> getCbUsuarios() {
        return cbUsuarios;
    }

    // Métodos
    private void inicializarComponentes() {

        labelUsuario = new JLabel("Legajo del usuario UTN");

        btnBuscar = new JButton("Buscar cuenta");

        cbUsuarios = new JComboBox<>();

    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Ocupa 1 columna
        gbc.weightx = 0; // No se expande en x
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(labelUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1; // Se expande en x
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(cbUsuarios, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(btnBuscar, gbc);

    }
}
