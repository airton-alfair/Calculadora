package br.com.alfair.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando {
            ZERAR, SINAL, NUMERO, MULT, DIV, SUB, SOMA, IGUAL, VIRGULA;
    };

    private static final Memoria instancia = new Memoria();

    private final List<MemoriaObservador> observadores =
            new ArrayList<>();

    private TipoComando ultimaOperacao = null;
    private boolean substituir = false;
    private String textoAtual = "";
    private String textoBuffer = "";


    public Memoria() {
    }

    public static Memoria getInstance(){
        return instancia;
    }

    public void adicionarObservador(MemoriaObservador observador){
        observadores.add(observador);
    }

    // Caso valor retorne zero ele tambem inicia com zero

    public String getTextoAtual(){
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    //Para processar novos comandos
    public void processarComando(String texto){

        TipoComando tipoComando = detectarTipoComando(texto);

        if(tipoComando == null){
            return;
        } else if(tipoComando == TipoComando.ZERAR) {
            textoAtual = "";
            textoBuffer = "";
            substituir = false;
            ultimaOperacao = null;
        } else if( tipoComando == TipoComando.SINAL && textoAtual.contains("-")) {
            textoAtual = textoAtual.substring(1);
        }else if( tipoComando == TipoComando.SINAL && !textoAtual.contains("-")){
            textoAtual = "-" + textoAtual;
        } else if( tipoComando == TipoComando.NUMERO
                || tipoComando == TipoComando.VIRGULA){
            textoAtual = substituir ? texto : textoAtual + texto;
            substituir = false;
        } else {
            substituir = true;
            textoAtual = obterResultadoOpercao();
            textoBuffer = textoAtual;
            ultimaOperacao = tipoComando;

        }

        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
    }

    //Logica de comando
    private String obterResultadoOpercao() {
        if(ultimaOperacao == null|| ultimaOperacao == TipoComando.IGUAL ){
            return textoAtual;
        }

        // Transformar a virgula em ponto
        double numeroBuffer =
                Double.parseDouble(textoBuffer.replace(",","."));
        double numeroAtual =
                Double.parseDouble(textoAtual.replace(",","."));

        double resultado = 0;

        if(ultimaOperacao == TipoComando.SOMA){
            resultado = numeroBuffer + numeroAtual;
        } else if(ultimaOperacao == TipoComando.SUB){
            resultado = numeroBuffer - numeroAtual;
        } else if(ultimaOperacao == TipoComando.MULT){
            resultado = numeroBuffer * numeroAtual;
        }else if(ultimaOperacao == TipoComando.DIV){
            resultado = numeroBuffer / numeroAtual;
        }

        //Aparicao de resultados
        String texto =
                Double.toString(resultado).replace(".", ",");

        boolean inteiro = texto.endsWith(",0"); // Para retirar o 0 de numeros inteiros
        return inteiro ? texto.replace(",0", ""): texto;
    }

    private TipoComando detectarTipoComando(String texto) {

        if(textoAtual.isEmpty() && texto =="0"){
            return null;
        }

        try {
            Integer.parseInt(texto); //Conversao de String para int
            return TipoComando.NUMERO;
        } catch (NumberFormatException e){
            // Quando nao for numero ..
            if("AC".equals(texto)){
               return TipoComando.ZERAR; // Limpar
            } else if("/".equals(texto)){
                return TipoComando.DIV;
            } else if("*".equals(texto)){
                return TipoComando.MULT;
            } else if("+".equals(texto)){
                return TipoComando.SOMA;
            } else if("-".equals(texto)) {
                return TipoComando.SUB;
            } else if("=".equals(texto)) {
                return TipoComando.IGUAL;
            } else if("±".equals(texto)) {
                return TipoComando.SINAL;
            } else if(",".equals(texto) && !textoAtual.contains(",")){
                return TipoComando.VIRGULA;
            }
        }
        return null;
    }

}
