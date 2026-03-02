package br.com.alfair.calc.visao;

import br.com.alfair.calc.modelo.Memoria;
import br.com.alfair.calc.modelo.MemoriaObservador;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel  implements MemoriaObservador {

    private final JLabel label;
    public Display(){
        Memoria.getInstance().adicionarObservador(this);

        setBackground(new Color(46, 49,50)); // Cor do fundo
        label = new JLabel(Memoria.getInstance().getTextoAtual());
        label.setForeground(Color.WHITE); // Cor da fonte
        label.setFont(new Font("courier",Font.PLAIN,30));// nome tipo e tamanho da fonte

        /**
         * Instanciando o proprio flowLayot voce consegue ver as classes e posições para aplicar
         * sendo mais facil usar o parametro do que aplicar numeracao
         * outros dois parametros para aplicar posicionamento
         */
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10,25));// Gerenciador de layout
        add(label);

    }


    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
