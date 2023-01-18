package org.tdd.execSemana3;

public class CaixaEletronico {

    private boolean clienteLogado = false;
    private String numeroConta;
    private String numeroCartao;
    private MockHardware hardware = new MockHardware();

    public String logar(String numeroConta, String numeroCartao) {
        if(numeroConta == null) {
            return "Não foi possível autenticar o usuário";
        }
        this.clienteLogado = true;
        this.numeroConta = numeroConta;
        this.numeroCartao = numeroCartao;
        return "Usuário Autenticado";
    }

    public String sacar(double saque) {
        hardware.entregarDinheiro(saque);
        return "Retire seu dinheiro";
    }

    public String depositar(double deposito) {
        hardware.lerEnvelope(deposito);
        return "Depósito recebido com sucesso";
    }

    public String saldo() {
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao(this.numeroCartao);

        return "O saldo é R$ " + String.format("%.2f", conta.getSaldo());
    }

    public boolean isClienteLogado() {
        return clienteLogado;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
