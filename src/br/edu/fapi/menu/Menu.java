package br.edu.fapi.menu;

import br.edu.fapi.jogo.ControllerJogo;

import java.util.Scanner;

public class Menu {
    private Scanner scan = new Scanner(System.in);
    private String escolha = "1";

    public void menu(){
        while(escolha.equalsIgnoreCase("1")) {
            //Essa parte aparece as parada na tela
            System.out.println("Ola tudo bem\n bem vindo ao jogo da forca!");
            System.out.printf("1 - Jogar e qualquer outro para sair\n>");

            //O usuario digita a escolha
            escolha = scan.next();

            //se for 1 Executa o jogo
            if (escolha.equalsIgnoreCase("1")) {
                ControllerJogo jogo = new ControllerJogo();
                jogo.jogar();
            }
        }
    }

}
