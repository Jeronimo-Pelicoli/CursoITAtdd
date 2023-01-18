package org.tdd;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JogoDoCeu {

    private final List<String> userName = new ArrayList<>();
    private final Placar placar = new Placar();

    public void addUsername(String userName) {
        this.userName.add(userName);
    }

    public JogoDoCeu() {

    }

    public void registrarPonto(String tipo, String ponto, String username) {
        String resultTipo = verificaTipoPonto(tipo);
        String resultPonto = verificaQuantidadePonto(ponto);
        String resultUserName = verificaSeUsernameEstaNoJogo(username);
        placar.registraTipoPontoParaUsuario(resultTipo, resultPonto, resultUserName);
    }

    public List<String> recuperarPontosDoUsuario(String name) {
        List<String> todosPontoDeUmUsuario = new ArrayList<>(placar.retornaTodosPontosDoUsuario(name));
        return todosPontoDeUmUsuario;
    }

    public List<String> retornaRank() {
        List<String> rank = placar.retornaRankDeUmTipoPonto(userName, "estrela");
        return rank;
    }

    public void encerraJogo() {
        for(String name: userName) {
            File files = new File("filefolder/" + name +".txt");
            files.delete();
        }
        userName.removeAll(userName);

    }

    private String verificaTipoPonto(String tipo) {
        String tipoPonto = "";
        switch (tipo) {
            case "estrela":
                tipoPonto = "estrela";
                break;
            case "lua":
                tipoPonto = "lua";
                break;
            case "sol":
                tipoPonto = "sol";
                break;
            default:
                throw new RuntimeException("Esse tipo de ponto não existe no jogo");
        }
        return tipoPonto;
    }

    private String verificaQuantidadePonto(String ponto) {
        String quantidadePonto = "";
        switch (ponto) {
            case "2":
                quantidadePonto = "2";
                break;
            case "5":
                quantidadePonto = "5";
                break;
            case "10":
                quantidadePonto = "10";
                break;
            default:
                throw new RuntimeException("Essa quantidade de ponto não existe no jogo");
        }
        return quantidadePonto;
    }

    private String verificaSeUsernameEstaNoJogo(String name) {
        String userExist = "";
        for(String user : userName) {
            if(user == name) {
                userExist = user;
            }
        }
        if(userExist.isEmpty()) {
            throw new RuntimeException("Essa nome de usuario não existe no jogo");
        }
        return userExist;
    }

}
