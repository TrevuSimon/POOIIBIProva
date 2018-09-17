package br.edu.fapi.file;

import br.edu.fapi.jogo.Jogo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileJogo {
    public void salvarRelatorio(List<Jogo> jogos, String nomeArquivo){
        String fileName = "c://"+nomeArquivo+".txt";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (Jogo jogo:jogos) {

               /* Nome: #Nome_Do_Jogador#
                Dificuldade: #Dificuldade_Escolhida_pelo_Jogador#
                Palavra: #Palavra_A_Ser_Adivinhada#
                Resultado: #Vitoria_Derrota_Interrompido#
                Data e Hora de Início: #Data_Hora_Inicio#
                Data e Hora de Fim: #Data_Hora_Fim#*/
                writer.write("Nome: "+ jogo.getJogador());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
