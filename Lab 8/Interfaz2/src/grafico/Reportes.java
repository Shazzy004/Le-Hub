package grafico;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.Becas;
import logica.Estudiantes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Reportes extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaBecados;
    private JComboBox<String> comboBoxCarreras;
    private JComboBox<String> comboBoxSexo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    setLookAndFeel();
                    Reportes frame = new Reportes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Reportes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 483);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(40, 44, 52));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Reportes");
        lblTitulo.setBounds(238, 10, 149, 46);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblTitulo.setForeground(new Color(173, 216, 230));
        contentPane.add(lblTitulo);

        JLabel lblEstudiantesBecados = new JLabel("Estudiantes Becados:");
        lblEstudiantesBecados.setBounds(52, 66, 221, 35);
        lblEstudiantesBecados.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEstudiantesBecados.setForeground(new Color(173, 216, 230));
        contentPane.add(lblEstudiantesBecados);

        textAreaBecados = new JTextArea();
        textAreaBecados.setEditable(false);
        textAreaBecados.setBounds(52, 111, 540, 220);
        textAreaBecados.setBackground(new Color(30, 34, 42));
        textAreaBecados.setForeground(new Color(173, 216, 230));
        textAreaBecados.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(textAreaBecados);

        JLabel lblCarrera = new JLabel("Carrera:");
        lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCarrera.setForeground(new Color(173, 216, 230));
        lblCarrera.setBounds(52, 350, 95, 22);
        contentPane.add(lblCarrera);

        comboBoxCarreras = new JComboBox<>();
        comboBoxCarreras.setModel(new DefaultComboBoxModel<>(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
        comboBoxCarreras.setBounds(157, 351, 153, 21);
        comboBoxCarreras.setSelectedIndex(-1);
        contentPane.add(comboBoxCarreras);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSexo.setForeground(new Color(173, 216, 230));
        lblSexo.setBounds(320, 350, 95, 22);
        contentPane.add(lblSexo);

        comboBoxSexo = new JComboBox<>();
        comboBoxSexo.setModel(new DefaultComboBoxModel<>(new String[] {"Masculino", "Femenino", "Otro"}));
        comboBoxSexo.setBounds(375, 351, 153, 21);
        comboBoxSexo.setSelectedIndex(-1);
        contentPane.add(comboBoxSexo);

        JButton btnBuscar = new CustomButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBuscar.setBounds(238, 382, 105, 23);
        contentPane.add(btnBuscar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String carrera = (String) comboBoxCarreras.getSelectedItem();
                String sexo = (String) comboBoxSexo.getSelectedItem();
                buscarBecados(carrera, sexo);
            }
        });
    }

    void mostrarBecados(Becas becas) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombres de los Estudiantes:\n");
        for (String nombre : becas.obtenerEstudiantesBecados()) {
            sb.append(nombre).append("\n");
        }
        textAreaBecados.setText(sb.toString());
    }

    private void buscarBecados(String carrera, String sexo) {
        ArrayList<Estudiantes> becados = Becas.buscarPorCarreraYSexo(carrera, sexo);
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiantes Becados:\n");
        for (Estudiantes estudiante : becados) {
            sb.append(estudiante.getNombre()).append("\n");
        }
        textAreaBecados.setText(sb.toString());
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


