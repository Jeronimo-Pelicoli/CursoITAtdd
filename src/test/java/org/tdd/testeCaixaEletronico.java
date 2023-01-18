package org.tdd;

import org.junit.Before;
import org.junit.Test;
import org.tdd.execSemana3.CaixaEletronico;
import org.tdd.execSemana3.ContaCorrente;
import org.tdd.execSemana3.MockHardware;

import static org.junit.Assert.*;

public class testeCaixaEletronico {

    private ContaCorrente contaCorrente;

    @Before
    public void inicializaContaCorrente() {
        contaCorrente = new ContaCorrente("4666", "4069", "John", 2000);
    }

    @Test
    public void DeveLogarOClienteComOCartao() {
        MockHardware hardware = new MockHardware();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao("4666");
        String mensagemLogado = caixaEletronico.logar(conta.getNumeroDaConta(), conta.getCartao());
        assertEquals("Usuário Autenticado", mensagemLogado);
        assertEquals(caixaEletronico.getNumeroConta(), contaCorrente.getNumeroDaConta());
        assertTrue(caixaEletronico.isClienteLogado());
    }

    @Test
    public void DeveDarErroDeLogin() {
        MockHardware hardware = new MockHardware();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao("4999");
        String mensagemLogado = caixaEletronico.logar(conta.getNumeroDaConta(), conta.getCartao());
        assertEquals("Não foi possível autenticar o usuário", mensagemLogado);
        assertFalse(caixaEletronico.isClienteLogado());
    }

    @Test
    public void DeveMostarOSaldoDaConta() {
        MockHardware hardware = new MockHardware();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao("4666");
        caixaEletronico.logar(conta.getNumeroDaConta(), conta.getCartao());
        assertTrue(caixaEletronico.isClienteLogado());
        assertEquals("O saldo é R$ 2000,00", caixaEletronico.saldo());
    }

    @Test
    public void DeveRealizarUmSaqueNaConta() {
        MockHardware hardware = new MockHardware();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao("4666");
        caixaEletronico.logar(conta.getNumeroDaConta(), conta.getCartao());
        assertTrue(caixaEletronico.isClienteLogado());

        double valorDoSaque = 500;
        double valorSaldoAtualizado = contaCorrente.getSaldo() - valorDoSaque;
        assertEquals("Retire seu dinheiro", caixaEletronico.sacar(valorDoSaque));
        assertEquals(caixaEletronico.saldo(), "O saldo é R$ " + String.format("%.2f",valorSaldoAtualizado));
    }

    @Test
    public void DeveRealizarUmDepositoNaConta() {
        MockHardware hardware = new MockHardware();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao("4666");
        caixaEletronico.logar(conta.getNumeroDaConta(), conta.getCartao());
        assertTrue(caixaEletronico.isClienteLogado());

        double valorDoDeposito = 500;
        double valorDoDepositoAtualizado = contaCorrente.getSaldo() + valorDoDeposito;
        assertEquals("Depósito recebido com sucesso", caixaEletronico.depositar(valorDoDeposito));
        assertEquals(caixaEletronico.saldo(), "O saldo é R$ " + String.format("%.2f",valorDoDepositoAtualizado));
    }

    @Test
    public void DeveRealizarDoisSaqueNaConta() {
        MockHardware hardware = new MockHardware();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao("4666");
        caixaEletronico.logar(conta.getNumeroDaConta(), conta.getCartao());
        assertTrue(caixaEletronico.isClienteLogado());

        double valorDoSaque = 500;
        double valorSaldoAtualizado = contaCorrente.getSaldo() - valorDoSaque;
        assertEquals("Retire seu dinheiro", caixaEletronico.sacar(valorDoSaque));
        assertEquals(caixaEletronico.saldo(), "O saldo é R$ " + String.format("%.2f",valorSaldoAtualizado));

        valorSaldoAtualizado = valorSaldoAtualizado - valorDoSaque;
        assertEquals("Retire seu dinheiro", caixaEletronico.sacar(valorDoSaque));
        assertEquals(caixaEletronico.saldo(), "O saldo é R$ " + String.format("%.2f",valorSaldoAtualizado));
    }

    @Test
    public void DeveRealizarDoisDepositoNaConta() {
        MockHardware hardware = new MockHardware();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaCorrente conta = hardware.pegarNumeroDaContaCartao("4666");
        caixaEletronico.logar(conta.getNumeroDaConta(), conta.getCartao());
        assertTrue(caixaEletronico.isClienteLogado());

        double valorDoDeposito = 500;
        double valorDoDepositoAtualizado = contaCorrente.getSaldo() + valorDoDeposito;
        assertEquals("Depósito recebido com sucesso", caixaEletronico.depositar(valorDoDeposito));
        assertEquals(caixaEletronico.saldo(), "O saldo é R$ " + String.format("%.2f",valorDoDepositoAtualizado));

        valorDoDeposito = 500;
        valorDoDepositoAtualizado = valorDoDepositoAtualizado + valorDoDeposito;
        assertEquals("Depósito recebido com sucesso", caixaEletronico.depositar(valorDoDeposito));
        assertEquals(caixaEletronico.saldo(), "O saldo é R$ " + String.format("%.2f",valorDoDepositoAtualizado));
    }
}
