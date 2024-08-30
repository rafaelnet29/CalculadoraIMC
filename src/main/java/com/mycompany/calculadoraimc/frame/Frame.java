package com.mycompany.calculadoraimc.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
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

        label = new JLabel("CALCULADORA IMC");
        labelAltura = new JLabel("ALTURA");
        labelPeso = new JLabel("PESO");
        txtAltura = new JTextField();
        txtPeso = new JTextField();
        btnCalcular = new JButton("CALCULAR IMC");
        btnSair = new JButton("Sair");
        txtResultado = new JTextArea();
        panel = new JPanel();
        
        label.setBounds(40, 10, 250, 100);
        label.setFont(new Font("ARIAl", Font.BOLD, 22));
        labelAltura.setBounds(40, 50, 120, 100);
        labelAltura.setFont(new Font("ARIAl", Font.BOLD, 18));
        txtAltura.setBounds(130, 90, 100, 20);
        labelPeso.setBounds(40, 90, 120, 100);
        labelPeso.setFont(new Font("ARIAl", Font.BOLD, 18));
        txtPeso.setBounds(130, 130, 100, 20);
        btnCalcular.setBounds(40, 170, 120, 20);
        btnSair.setBounds(170, 170, 90, 20);
        txtResultado.setBounds(60, 220, 170, 40);
        txtResultado.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        txtResultado.setFont(new Font("ARIAl", Font.BOLD, 22));
        txtResultado.setLineWrap(true);
        txtResultado.setEditable(false);

        panel.setPreferredSize(new Dimension(300, 400));
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
        this.setLocationRelativeTo(null);
        
        CulcularIMC();
        Sair();

    }
    
    public JButton CulcularIMC() {
        btnCalcular.addActionListener((e) -> {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            
            double imc = peso / (altura * altura);
            txtResultado.setText("Seu IMC : " + new DecimalFormat("#.00").format(imc));
        });
        return btnCalcular;
    }
    public JButton Sair() {
        btnSair.addActionListener((e) -> {
            this.dispose();
        });
        return btnSair;
    }
}
