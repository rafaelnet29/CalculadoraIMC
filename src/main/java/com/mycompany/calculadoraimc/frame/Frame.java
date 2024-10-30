package com.mycompany.calculadoraimc.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class Frame extends JFrame {

    JLabel label;
    JLabel labelAltura;
    JLabel labelPeso;
    JTextField txtAltura;
    JTextField txtPeso;
    JButton btnCalcular;
    JButton btnSair;
    JTextArea txtResultado;
    JPanel panel;

    public Frame() {
        CriarFrame();
        CalcularIMC();
        Sair();
    }

    public JButton CalcularIMC() {
        btnCalcular.addActionListener((e) -> {
            Resultado();
            txtAltura.setText("");
            txtPeso.setText("");
        });
        return btnCalcular;
    }

    public JButton Sair() {
        btnSair.addActionListener((e) -> {
            this.dispose();
        });
        return btnSair;
    }

    public Double Resultado() {
        double peso = Double.parseDouble(txtPeso.getText());
        double altura = Double.parseDouble(txtAltura.getText());

        double imc = peso / (altura * altura);
        if (imc < 18.5) {
            txtResultado.setText(MessageFormat.format("Seu IMC : {0} \n{1}",
                    new DecimalFormat("#.00").format(imc), " MAGREZA PREUCUPANTE!! "));
            txtResultado.setForeground(Color.red);
        } else if ((imc >= 18.5) && (imc < 24.9)) {
            txtResultado.setText(MessageFormat.format("Seu IMC : {0} \n{1}",
                    new DecimalFormat("#.00").format(imc), " NORMAL!! "));
            txtResultado.setForeground(Color.blue);
        } else if ((imc >= 25) && (imc < 29.9)) {
            txtResultado.setText(MessageFormat.format("Seu IMC : {0} \n{1}",
                    new DecimalFormat("#.00").format(imc), " SOBREPESO!! "));
            txtResultado.setForeground(Color.green);
        } else if ((imc >= 30) && (imc < 34.9)) {
            txtResultado.setText(MessageFormat.format("Seu IMC : {0} \n{1}",
                    new DecimalFormat("#.00").format(imc), " OBESIDADE GRAU #1!! "));
            txtResultado.setForeground(Color.yellow);
        } else if ((imc >= 35) && (imc < 39.9)) {
            txtResultado.setText(MessageFormat.format("Seu IMC : {0} \n{1}",
                    new DecimalFormat("#.00").format(imc), " OBESIDADE GRAU #2!! "));
            txtResultado.setForeground(Color.DARK_GRAY);
        } else {
            txtResultado.setText(MessageFormat.format("Seu IMC : {0} \n{1}",
                    new DecimalFormat("#.00").format(imc), " OBESIDADE GRAU #3!! "));
            txtResultado.setForeground(Color.black);
        }
        return imc;
    }

    public void CriarFrame() {
        label = new JLabel("CALCULADORA IMC");
        labelAltura = new JLabel("ALTURA");
        labelPeso = new JLabel("PESO");
        txtAltura = new JTextField();
        txtPeso = new JTextField();
        btnCalcular = new JButton("CALCULAR IMC");
        btnSair = new JButton("Sair");
        txtResultado = new JTextArea();
        panel = new JPanel();

        label.setBounds(40, 5, 250, 100);
        label.setForeground(Color.red);
        label.setFont(new Font("ARIAL", Font.BOLD, 22));
        labelAltura.setBounds(40, 50, 120, 100);
        labelAltura.setFont(new Font("ARIAL", Font.BOLD, 18));
        txtAltura.setBounds(130, 90, 100, 20);
        labelPeso.setBounds(40, 90, 120, 100);
        labelPeso.setFont(new Font("ARIAL", Font.BOLD, 18));
        txtPeso.setBounds(130, 130, 100, 20);
        btnCalcular.setBounds(40, 170, 120, 20);
        btnSair.setBounds(170, 170, 70, 20);
        txtResultado.setBounds(40, 220, 200, 60);
        txtResultado.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        txtResultado.setFont(new Font("ARIAL", Font.BOLD, 14));
        txtResultado.setLineWrap(true);
        txtResultado.setEditable(false);

        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.CYAN);
        panel.add(label);
        panel.add(labelAltura);
        panel.add(labelPeso);
        panel.add(txtAltura);
        panel.add(txtPeso);
        panel.add(btnCalcular);
        panel.add(btnSair);
        panel.add(txtResultado);
        panel.setLayout(null);

        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
