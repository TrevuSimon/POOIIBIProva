package br.edu.fapi.jogo;

import java.util.Scanner;

public class ControllerJogo {
    private Jogo jogo;
    private int statusJogo = 0;
    private Scanner scan = new Scanner(System.in);
    //0 para continua, 1 para perdeu 2 para ganhou;

    public void jogar() {
        //Jogador digita palavra do jogo
        System.out.printf("Digite a palavra da forca.\n>");
        String palavraDitada = scan.next();
        jogo = new Jogo(palavraDitada);
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        while(statusJogo == 0){

            statusJogo = jogo.verificaJogo();
            if(statusJogo != 0) break;

            jogo.exibirForca();

            jogo.chuteLetra();
        }

        jogo.resultado(statusJogo);
    }
}
