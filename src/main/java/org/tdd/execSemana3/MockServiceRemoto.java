package org.tdd.execSemana3;

public class MockServiceRemoto implements ServiceRemoto {

    private ContaCorrente contaCorrente = new ContaCorrente("4666", "4069", "John", 2000);

    @Override
    public ContaCorrente recuperarConta(String cartao) {
        if(cartao == contaCorrente.getCartao()) {
            return contaCorrente;
        } else {
            ContaCorrente contaVazia = new ContaCorrente();
            return contaVazia;
        }
    }

    @Override
    public void persistirConta(double valor, String operador) {
        double valorSaldoAtualizado = 0;
        if(operador  == "soma") {
            valorSaldoAtualizado = contaCorrente.getSaldo() + valor;
        } else if(operador == "subtracao"){
            valorSaldoAtualizado = contaCorrente.getSaldo() - valor;
        }
        contaCorrente.setSaldo(valorSaldoAtualizado);
    }
}
