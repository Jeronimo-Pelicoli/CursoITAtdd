package org.tdd.execSemana3;

public class ContaCorrente {

    private String cartao;
    private String numeroDaConta;
    private String cliente;
    private double saldo;

    public ContaCorrente() {

    }

    public ContaCorrente(String cartao, String numeroDaConta, String cliente, double saldo) {
        this.cartao = cartao;
        this.numeroDaConta = numeroDaConta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public String getCartao() {
        return cartao;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
