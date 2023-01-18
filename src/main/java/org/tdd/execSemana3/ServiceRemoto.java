package org.tdd.execSemana3;

public interface ServiceRemoto {

    public ContaCorrente recuperarConta(String cartao);

    public void persistirConta(double valor, String operador);
}
