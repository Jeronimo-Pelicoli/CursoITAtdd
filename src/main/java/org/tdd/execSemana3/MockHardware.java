package org.tdd.execSemana3;

public class MockHardware implements Hardware {

    private MockServiceRemoto serviceRemoto = new MockServiceRemoto();

    @Override
    public ContaCorrente pegarNumeroDaContaCartao(String cartao) {
        return serviceRemoto.recuperarConta(cartao);
    }

    @Override
    public void entregarDinheiro(double saque) {
        serviceRemoto.persistirConta(saque, "subtracao");
    }

    @Override
    public void lerEnvelope(double deposito) {
        serviceRemoto.persistirConta(deposito, "soma");
    }
}
