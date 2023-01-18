package org.tdd;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class testeGamificacao {

    @Test
    public void deveArmazenarPontosDeUmJogador() {
        JogoDoCeu jogoDoCeu = new JogoDoCeu();
        jogoDoCeu.addUsername("Jeronimo");
        jogoDoCeu.registrarPonto("sol", "5", "Jeronimo");
        jogoDoCeu.registrarPonto("lua", "5", "Jeronimo");
        jogoDoCeu.registrarPonto("estrela", "5", "Jeronimo");
        jogoDoCeu.registrarPonto("estrela", "5", "Jeronimo");
        List<String> todosOsPontosJeronimo = Arrays.asList("sol 5", "estrela 10", "lua 5");
        List<String> todosPontoDeUmUsuarioJeronimo = new ArrayList<>(jogoDoCeu.recuperarPontosDoUsuario("Jeronimo"));
        assertEquals(todosOsPontosJeronimo, todosPontoDeUmUsuarioJeronimo);
        jogoDoCeu.encerraJogo();
    }

    @Test
    public void deveArmazenarPontosDeDoisJogadores() {
        JogoDoCeu jogoDoCeu = new JogoDoCeu();
        jogoDoCeu.addUsername("Jeronimo");
        jogoDoCeu.addUsername("John");
        jogoDoCeu.registrarPonto("sol", "5", "Jeronimo");
        jogoDoCeu.registrarPonto("sol", "5", "Jeronimo");
        jogoDoCeu.registrarPonto("lua", "5", "John");
        jogoDoCeu.registrarPonto("lua", "5", "Jeronimo");
        jogoDoCeu.registrarPonto("estrela", "5", "Jeronimo");
        jogoDoCeu.registrarPonto("estrela", "5", "John");
        jogoDoCeu.registrarPonto("estrela", "5", "Jeronimo");
        List<String> todosOsPontosJeronimo = Arrays.asList("sol 10", "estrela 10", "lua 5");
        List<String> todosOsPontosJohn = Arrays.asList("estrela 5", "lua 5");
        List<String> todosPontoDeUmUsuarioJeronimo = new ArrayList<>(jogoDoCeu.recuperarPontosDoUsuario("Jeronimo"));
        List<String> todosPontoDeUmUsuarioJohn = new ArrayList<>(jogoDoCeu.recuperarPontosDoUsuario("John"));
        assertEquals(todosOsPontosJeronimo, todosPontoDeUmUsuarioJeronimo);
        assertEquals(todosOsPontosJohn, todosPontoDeUmUsuarioJohn);
        jogoDoCeu.encerraJogo();
    }

    @Test
    public void deveRetornarRankDosJogadores() {
        JogoDoCeu jogoDoCeu = new JogoDoCeu();
        jogoDoCeu.addUsername("Ana");
        jogoDoCeu.addUsername("John");
        jogoDoCeu.addUsername("Jeronimo");
        jogoDoCeu.registrarPonto("estrela", "5", "John");
        jogoDoCeu.registrarPonto("estrela", "2", "Ana");
        jogoDoCeu.registrarPonto("estrela", "10", "Ana");
        jogoDoCeu.registrarPonto("estrela", "10", "Ana");
        jogoDoCeu.registrarPonto("estrela", "10", "Jeronimo");
        jogoDoCeu.registrarPonto("estrela", "10", "Jeronimo");
        List<String> rank = jogoDoCeu.retornaRank();
        List<String> rankEsperrado = Arrays.asList("Ana estrela 22", "Jeronimo estrela 20", "John estrela 5");
        assertEquals(rankEsperrado, rank);
        jogoDoCeu.encerraJogo();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void deveAcontecerUmErroPeloTipoDePontoErrado() throws Exception {
        JogoDoCeu jogoDoCeu = new JogoDoCeu();
        jogoDoCeu.addUsername("John");
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Esse tipo de ponto não existe no jogo");
        jogoDoCeu.registrarPonto("terra", "2", "John");
    }

    @Test
    public void deveAcontecerUmErroPeloQuantidadeDePontoErrado() throws Exception {
        JogoDoCeu jogoDoCeu = new JogoDoCeu();
        jogoDoCeu.addUsername("John");
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Essa quantidade de ponto não existe no jogo");
        jogoDoCeu.registrarPonto("sol", "3", "John");
    }

    @Test
    public void deveAcontecerUmErroPeloNomeDeJogadorErrado() throws Exception {
        JogoDoCeu jogoDoCeu = new JogoDoCeu();
        jogoDoCeu.addUsername("John");
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Essa nome de usuario não existe no jogo");
        jogoDoCeu.registrarPonto("sol", "2", "pedro");
    }
}
