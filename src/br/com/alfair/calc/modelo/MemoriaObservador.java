package br.com.alfair.calc.modelo;

@FunctionalInterface
public interface MemoriaObservador {

    public void valorAlterado(String novoValor);
}
