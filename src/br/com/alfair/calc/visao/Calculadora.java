/**
 *
 * @author Airton Alfair
 */

package br.com.alfair.calc.visao;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {

    public Calculadora(){

        organizarLayout();

        setSize(232, 322); // Tamanho da calc
        //setUndecorated(true); // Tirar a barra da aplicacao podendo criar uma propria
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fechar a aplicacao quando apertado no X
        setLocationRelativeTo(null);// Para centralizar na tela quando aberto
        setVisible(true); // Inicar a tela
    }

    //Tipo de organizador de layout
    private void organizarLayout() {
        setLayout(new BorderLayout());

        //Instanciar display recebendo por heranca
        Display display = new Display();
        display.setPreferredSize(new Dimension(233,60)); // Tamanho do display
        add(display, BorderLayout.NORTH); // Adicionando display com localizacao
        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER); // Encaixando-o no centro

    }


    public static void main(String[] args) {
        new Calculadora();
    }

}
