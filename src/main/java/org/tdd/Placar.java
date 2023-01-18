package org.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Placar {

    private final Armazenamento armazenamento = new Armazenamento();

    public void registraTipoPontoParaUsuario(String tipo, String ponto, String username) {
        armazenamento.armazenarPontosTipos(tipo, ponto, username);
    }

    public List<String> retornaTodosPontosDoUsuario(String name) {
        Set<String> todosTiposDePonto = armazenamento.retornarTodosTiposPontos(name);
        List<String> todosOsPontos = new ArrayList<>();
        todosTiposDePonto.forEach(tipo -> {
            todosOsPontos.add(armazenamento.recuperarPontosTipos(tipo, name));
        });

        return todosOsPontos;
    }

    public List<String> retornaRankDeUmTipoPonto(List<String> userName, String tipo) {
        List<String> userQueTemPontos = armazenamento.retornarUsuariosQueTemPontos(userName);
        List<String> rank = new ArrayList<>();
        userQueTemPontos.forEach(user -> {
            rank.add(user + " " + armazenamento.recuperarPontosTipos(tipo, user));
        });

        for (int i = 0; i < rank.size(); i++) {

            for(int j = 1; j < rank.size() - i; j++) {
                String[] stringquebrada1 = rank.get(j -1).split(" ");
                Integer valor1 = Integer.parseInt(stringquebrada1[2]);

                String[] stringquebrada2 = rank.get(j).split(" ");
                Integer valor2 = Integer.parseInt(stringquebrada2[2]);

                if(valor1 < valor2) {
                    String temp = rank.get(j -1);
                    rank.set(j -1, rank.get(j));
                    rank.set(j, temp);
                }
            }
        }

        return rank;
    }
}
