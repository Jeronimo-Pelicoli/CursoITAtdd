package org.tdd;

import java.io.*;
import java.util.*;

public class Armazenamento {


    public void armazenarPontosTipos(String tipo, String ponto, String username) {
        String line = tipo + " " + ponto;
        String path = "filefolder/" + username + ".txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String recuperarPontosTipos(String tipo, String name) {
        String path = "filefolder/" + name + ".txt";
        int valorPonto = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while(( line = br.readLine()) != null) {
                if(line.contains(tipo)) {
                    String[] result = line.split(" ");
                    valorPonto += Integer.parseInt(result[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tipo + " " + valorPonto;
    }

    public List<String> retornarUsuariosQueTemPontos(List<String> userName) {
        List<String> success = new ArrayList<>();
        for(String user : userName) {
            String path = "filefolder/" + user + ".txt";
            try (FileInputStream fr = new FileInputStream(new File(path))) {
                success.add(user);
            } catch (FileNotFoundException e ) {
                e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public Set<String> retornarTodosTiposPontos(String name) {
        String path = "filefolder/" + name + ".txt";
        Set<String> success = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while(( line = br.readLine()) != null) {
                String[] result = line.split(" ");
                success.add(result[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }
}
