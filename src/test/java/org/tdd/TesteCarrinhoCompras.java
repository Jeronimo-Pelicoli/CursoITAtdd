package org.tdd;

import org.junit.Test;
import org.tdd.semana2.CarrinhoCompras;
import org.tdd.semana2.MockObservadorCarrinho;
import org.tdd.semana2.Produto;

import static org.junit.Assert.assertEquals;

public class TesteCarrinhoCompras {

    @Test
    public void totalCarrinho() {
        CarrinhoCompras c = new CarrinhoCompras();
        c.adicionaProduto(new Produto("Tenis", 100));
        c.adicionaProduto(new Produto("camiseta", 50));
        c.adicionaProduto(new Produto("bermuda", 70));
        assertEquals(220, c.total());
    }

    @Test
    public void escutaAdicaoDeProduto() {
        CarrinhoCompras c = new CarrinhoCompras();
        MockObservadorCarrinho mock = new MockObservadorCarrinho();
        c.adicionarObervador(mock);
        c.adicionaProduto(new Produto("tenis", 100));
        mock.verificaRecebimentoProduto("tenis", 100);
    }

    @Test
    public void AdicionarDoisObservadores() {
        CarrinhoCompras c = new CarrinhoCompras();
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        c.adicionarObervador(mock1);
        c.adicionarObervador(mock2);
        c.adicionaProduto(new Produto("tenis", 100));
        mock1.verificaRecebimentoProduto("tenis", 100);
        mock2.verificaRecebimentoProduto("tenis", 100);
    }

    @Test
    public void continuaNotificandoComErroEmObservador() {
        CarrinhoCompras c = new CarrinhoCompras();
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        mock2.queroQueVoceDePau();
        MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
        c.adicionarObervador(mock1);
        c.adicionarObervador(mock2);
        c.adicionarObervador(mock3);
        c.adicionaProduto(new Produto("tenis", 100));
        mock1.verificaRecebimentoProduto("tenis", 100);
        mock3.verificaRecebimentoProduto("tenis", 100);
    }
}
