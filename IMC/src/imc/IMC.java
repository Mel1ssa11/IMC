/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMC extends JFrame {

    Container tela;
    JLabel titulo, labelPeso, labelAltura, resultado;
    JTextField textoPeso, textoAltura;
    JButton calcular;

    public IMC() {

        super("Calculadora IMC");

        tela = getContentPane();
        tela.setLayout(null);
        tela.setBackground(new Color(142, 210, 188));

        titulo = new JLabel("Calculadora de IMC");
        titulo.setBounds(0, 20, 400, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titulo.setForeground(new Color(26, 75, 131));

        labelPeso = new JLabel("Peso:");
        labelAltura = new JLabel("Altura:");
        labelPeso.setBounds(50, 100, 100, 25);
        labelAltura.setBounds(50, 150, 100, 25);

        textoPeso = new JTextField();
        textoAltura = new JTextField();
        textoPeso.setBounds(150, 100, 150, 25);
        textoAltura.setBounds(150, 150, 150, 25);

        calcular = new JButton("Calcular IMC");
        calcular.setBounds(100, 220, 180, 30);
        calcular.setBackground(new Color(246, 86, 65));
        calcular.setForeground(Color.WHITE);

        resultado = new JLabel("Resultado");
        resultado.setBounds(0, 300, 400, 30);
        resultado.setHorizontalAlignment(SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 18));
        resultado.setForeground(new Color(26, 75, 131));

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    double peso = Double.parseDouble(textoPeso.getText().replace(",", "."));
                    double altura = Double.parseDouble(textoAltura.getText().replace(",", "."));

                    double imc = peso / (altura * altura);

                    if (imc < 18.5) {

                        resultado.setText(String.format("IMC:  Abaixo do peso", imc));

                    } else if (imc >= 18.5 && imc <= 24.99) {

                        resultado.setText(String.format("IMC:  Peso ideal", imc));

                    } else {

                        resultado.setText(String.format("IMC:  Acima do peso", imc));

                    }

                } catch (NumberFormatException erro) {

                    JOptionPane.showMessageDialog(null,
                            "Digite apenas numeros validos");

                }
            }
        });

        tela.add(titulo);

        tela.add(labelPeso);
        tela.add(labelAltura);

        tela.add(textoPeso);
        tela.add(textoAltura);

        tela.add(calcular);

        tela.add(resultado);

        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
