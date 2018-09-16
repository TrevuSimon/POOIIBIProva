package br.edu.fapi.menu;

import br.edu.fapi.jogo.ControllerJogo;

import java.util.Scanner;

public class Menu {
	private Scanner scan = new Scanner(System.in);
	private String escolha = "1";

	public void menu() {
		while (escolha.equalsIgnoreCase("1")) {
			// O usuario digita a escolha
			escolha = scan.next();

			// se for 1 Executa o jogo
			if ("1".equalsIgnoreCase(escolha)) {
				ControllerJogo jogo = new ControllerJogo();
				jogo.jogar();
			}
		}
	}

	public void wellcome() {
		System.out.println("==========================================================");
		System.out.println("+                                                        +");
		System.out.println("+             Bem Vindos ao Jogo da Forca                +");
		System.out.println("+                                                        +");
		System.out.println("+ ( 1 ) JOGAR :)                                         +");
		System.out.println("+ ( 0 ) ABANDONAR JOGO :(                                +");
		System.out.println("==========================================================");
	}

}
