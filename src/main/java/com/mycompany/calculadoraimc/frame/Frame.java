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
    JLabel labelVersion;
    JTextField txtAltura;
    JTextField txtPeso;
    JButton btnCalcular;
    JButton btnSair;
    JButton btnLimpar;
    JTextArea txtResultado;
    JPanel panel;

    /***
     * Metodo construtor
     */
    public Frame() {
        CriarFrame();
        CalcularIMC();
        Sair();
        Limpar();
    }
    
    /***
     * Metodo responsavel para
     * acionar o calculo do IMC
     * @return calcular IMC
     */
    public JButton CalcularIMC() {
        btnCalcular.addActionListener((e) -> {
            Resultado();
        });
        return btnCalcular;
    }
    
     /***
     * Metodo responsavel para encerrar
     * o frame 
     * @return metodo Sair
     */
    public JButton Sair() {
        btnSair.addActionListener((e) -> {
            this.dispose();
        });
        return btnSair;
    }
    
    /***
     * Metodo responsavel para limpar
     * os campos do frame 
     * @return metodo Limpar
     */
    public JButton Limpar(){
        btnLimpar.addActionListener((e) -> {
            txtAltura.setText("");
            txtPeso.setText("");
            txtResultado.setText("");
        });
        return btnLimpar;
    }    
    /***
     * metodo responsavel para 
     * calcular e mostrar o resultado
     * do calculo do IMC
     * @return Calculo do IMC 
     */
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
    
    /***
     * Metodo para criar o frame 
     * contendo todas as configurações
     * para seu funcionamento
     */
    public void CriarFrame() {
        //instancias dos componentes
        label = new JLabel("CALCULADORA IMC");
        labelAltura = new JLabel("ALTURA");
        labelPeso = new JLabel("PESO");
        labelVersion = new JLabel("2.1.0v");
        txtAltura = new JTextField();
        txtPeso = new JTextField();
        btnCalcular = new JButton("CALCULAR IMC");
        btnSair = new JButton("SAIR");
        btnLimpar = new JButton("LIMPAR");
        txtResultado = new JTextArea();
        panel = new JPanel();
        
        //configuração dos componentes
        label.setBounds(20, 3, 270, 110);
        label.setForeground(Color.red);
        label.setFont(new Font("ARIAL", Font.BOLD, 26));
        labelAltura.setBounds(40, 50, 120, 100);
        labelAltura.setFont(new Font("ARIAL", Font.BOLD, 18));
        txtAltura.setBounds(130, 90, 100, 20);
        labelPeso.setBounds(40, 90, 120, 100);
        labelPeso.setFont(new Font("ARIAL", Font.BOLD, 18));
        labelVersion.setBounds(10, 280, 50, 20);
        labelVersion.setEnabled(false);
        txtPeso.setBounds(130, 130, 100, 20);
        btnCalcular.setBounds(80, 160, 120, 20);
        btnSair.setBounds(170, 193, 70, 20);
        btnLimpar.setBounds(40, 193, 80, 20);
        txtResultado.setBounds(40, 220, 200, 60);
        txtResultado.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        txtResultado.setFont(new Font("ARIAL", Font.BOLD, 14));
        txtResultado.setLineWrap(true);
        txtResultado.setEditable(false);
        
        /***
         * configuração e adição dos componentes 
         * no JPanel
         */
        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.CYAN);
        panel.add(label);
        panel.add(labelAltura);
        panel.add(labelPeso);
        panel.add(labelVersion);
        panel.add(txtAltura);
        panel.add(txtPeso);
        panel.add(btnCalcular);
        panel.add(btnSair);
        panel.add(btnLimpar);
        panel.add(txtResultado);
        panel.setLayout(null);
        
        //configuração do JFrame
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
