package grafico;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.Estudiantes;
import logica.Becas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Formulario extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textIndice;
    private JTextField textCedula;
    private Estudiantes estudiante;
    private JComboBox<String> comboBoxCarreras;
    private JComboBox<String> comboBoxSexo;
    private ArrayList<Estudiantes> estudiantes;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    setLookAndFeel();
                    Formulario frame = new Formulario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Formulario() {
        estudiantes = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 932, 552);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(40, 44, 52));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Información de Estudiantes");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblTitulo.setForeground(new Color(173, 216, 230));
        lblTitulo.setBounds(277, 10, 271, 62);
        contentPane.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNombre.setForeground(new Color(173, 216, 230));
        lblNombre.setBounds(21, 97, 95, 22);
        contentPane.add(lblNombre);

        textNombre = new CustomTextField();
        textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textNombre.setBounds(141, 102, 153, 19);
        contentPane.add(textNombre);
        textNombre.setColumns(10);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCedula.setForeground(new Color(173, 216, 230));
        lblCedula.setBounds(21, 166, 95, 22);
        contentPane.add(lblCedula);

        textCedula = new CustomTextField();
        textCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textCedula.setColumns(10);
        textCedula.setBounds(141, 167, 153, 19);
        contentPane.add(textCedula);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSexo.setForeground(new Color(173, 216, 230));
        lblSexo.setBounds(21, 239, 95, 22);
        contentPane.add(lblSexo);

        comboBoxSexo = new JComboBox<>();
        comboBoxSexo.setModel(new DefaultComboBoxModel<>(new String[] {"Masculino", "Femenino", "Otro"}));
        comboBoxSexo.setBounds(141, 240, 153, 21);
        comboBoxSexo.setSelectedIndex(-1);
        contentPane.add(comboBoxSexo);

        JLabel lblIndice = new JLabel("Índice:");
        lblIndice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblIndice.setForeground(new Color(173, 216, 230));
        lblIndice.setBounds(21, 308, 95, 22);
        contentPane.add(lblIndice);

        textIndice = new CustomTextField();
        textIndice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textIndice.setColumns(10);
        textIndice.setBounds(141, 309, 153, 19);
        contentPane.add(textIndice);

        JLabel lblCarrera = new JLabel("Carrera:");
        lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCarrera.setForeground(new Color(173, 216, 230));
        lblCarrera.setBounds(21, 377, 95, 22);
        contentPane.add(lblCarrera);

        comboBoxCarreras = new JComboBox<>();
        comboBoxCarreras.setModel(new DefaultComboBoxModel<>(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
        comboBoxCarreras.setBounds(141, 378, 153, 21);
        comboBoxCarreras.setSelectedIndex(-1);
        contentPane.add(comboBoxCarreras);

        JButton btnGuardar = new CustomButton("Guardar Datos");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnGuardar.setBounds(460, 163, 184, 34);
        contentPane.add(btnGuardar);

        JButton btnReportes = new CustomButton("Mostrar Reportes");
        btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnReportes.setBounds(700, 361, 184, 34);
        contentPane.add(btnReportes);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Becas becas = new Becas();
                for (Estudiantes estudiante : estudiantes) {
                    becas.agregarEstudiante(estudiante);
                }
                Reportes reportes = new Reportes();
                reportes.setVisible(true);
                reportes.mostrarBecados(becas);
            }
        });

        JLabel lblBusqueda = new JLabel("Buscar por Cédula:");
        lblBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBusqueda.setForeground(new Color(173, 216, 230));
        lblBusqueda.setBounds(460, 97, 153, 22);
        contentPane.add(lblBusqueda);

        JTextField textBusqueda = new CustomTextField();
        textBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textBusqueda.setBounds(625, 102, 153, 19);
        contentPane.add(textBusqueda);

        JButton btnBuscar = new CustomButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBuscar.setBounds(790, 100, 105, 23);
        contentPane.add(btnBuscar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = textBusqueda.getText();
                buscarPorCedula(cedula);
            }
        });
    }

    private void guardarDatos() {
        try {
            String nombre = textNombre.getText();
            String cedula = textCedula.getText();
            String sexo = (String) comboBoxSexo.getSelectedItem();
            double indice = Double.parseDouble(textIndice.getText());
            if (indice < 0 || indice > 3) {
                throw new NumberFormatException();
            }
            String carrera = (String) comboBoxCarreras.getSelectedItem();
            Estudiantes estudiante = new Estudiantes(nombre, cedula, carrera, sexo, indice);
            estudiantes.add(estudiante);
            JOptionPane.showMessageDialog(this, "Información guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            textNombre.setText("");
            textCedula.setText("");
            comboBoxSexo.setSelectedIndex(-1);
            textIndice.setText("");
            comboBoxCarreras.setSelectedIndex(-1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un índice válido (0-3).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPorCedula(String cedula) {
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                JOptionPane.showMessageDialog(this, estudiante.toString(), "Estudiante Encontrado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Estudiante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.put("control", new Color(30, 34, 42));
            UIManager.put("info", new Color(30, 34, 42));
            UIManager.put("nimbusBase", new Color(30, 34, 42));
            UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
            UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
            UIManager.put("nimbusFocus", new Color(115, 164, 209));
            UIManager.put("nimbusGreen", new Color(176, 179, 50));
            UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
            UIManager.put("nimbusLightBackground", new Color(30, 34, 42));
            UIManager.put("nimbusOrange", new Color(191, 98, 4));
            UIManager.put("nimbusRed", new Color(169, 46, 34));
            UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
            UIManager.put("nimbusSelectionBackground", new Color(115, 164, 209));
            UIManager.put("text", new Color(230, 230, 230));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CustomButton extends JButton {
    public CustomButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(new Color(173, 216, 230));
        setFont(new Font("Tahoma", Font.PLAIN, 18));
        setPreferredSize(new Dimension(184, 34));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Sombra
        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 15, 15);

        // Fondo del botón
        g2d.setColor(new Color(50, 54, 62));
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);

        super.paintComponent(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(40, 44, 52));
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        g2d.dispose();
    }
}

class CustomTextField extends JTextField {
    public CustomTextField() {
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setForeground(new Color(173, 216, 230));
        setFont(new Font("Tahoma", Font.PLAIN, 20));
        setPreferredSize(new Dimension(300, 30));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 15, 15);

        g2d.setColor(new Color(50, 54, 62));
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);

        super.paintComponent(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(40, 44, 52));
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        g2d.dispose();
    }
}
