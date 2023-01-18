package org.tdd.execSemana3;

public interface Hardware {



    public ContaCorrente pegarNumeroDaContaCartao(String cartao);

    public void entregarDinheiro(double saque);

    public void lerEnvelope(double deposito);
}
