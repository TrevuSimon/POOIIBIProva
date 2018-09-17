package br.edu.fapi.menu;

import br.edu.fapi.file.ControllerFile;
import br.edu.fapi.jogo.ControllerJogo;

import java.io.IOException;
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
		System.out.println("+             BEM VINDOS AO JOGO DA FORCA                +");
		System.out.println("+                                                        +");
		System.out.println("+ ( 1 ) Jogar                                            +");
		System.out.println("+ ( 0 )	Sair                                             +");
		System.out.println("==========================================================");
	}

	public void report() {
		System.out.println("==========================================================");
		System.out.println("+                                                        +");
		System.out.println("+         FIM DE JOGO DESEJA GERAR O RELATORIO           +");
		System.out.println("+                                                        +");
		System.out.println("+ ( 1 ) Gerar Relatório Geral                            +");
		System.out.println("+ ( 2 ) Gerar Relatório de Vitórias                      +");
		System.out.println("+ ( 3 ) Gerar Relatório de Derrotas                      +");
		System.out.println("==========================================================");
		ControllerFile report = new ControllerFile();
		report.files_createDirectory();
	}
}
