package br.edu.fapi.jogo;

import br.edu.fapi.dao.JogoDAO;
import br.edu.fapi.dao.impl.JogoDAOImpl;
import br.edu.fapi.jogo.palavra.Palavra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	
	//Atributos
    private int idJogo;
    private String jogador;
    private Palavra palavra = new Palavra();
    private List<String> letras = new ArrayList<String>();
    private String dificuldade;
    private int vida = 5;
    private Scanner scan = new Scanner(System.in);
    private JogoDAO jogoDAO = new JogoDAOImpl();


    //Contrutor
    public Jogo(String palavra){
        palavra = palavra.toLowerCase();
        letras.add(" ");
        this.palavra.setPalavra(palavra);

        this.defineJogador();
        this.defineDificuldade();



        //Na hora que um jogo novo começa ele cria um registro no banco de dados.
        jogoDAO.cadastrarJogo(this);

    }

    public void defineJogador(){
        System.out.printf("\n\nNome do jogador! > ");
        jogador = scan.next();
    }

    public void defineDificuldade(){
        String escolha;
        do {


            System.out.printf("\n\nEscolha dificuldade 1 - facil, 2 - medio 3 - dificil > ");
            escolha = scan.next();
            escolha = escolha.toLowerCase();
            escolha = "" + escolha.charAt(0);

            if ("1".equals(escolha)) {
                dificuldade = "Facil";
                vida = 3;
                break;
            }else if("2".equals(escolha)){
                dificuldade = "Medio";
                vida = 5;
                break;
            }else if("3".equals(escolha)){
                dificuldade = "Dificil";
                vida = 7;
                break;
            }

        }while(true);
    }

    public int verificaJogo() {
        if(vida <= 0){
            return 1;//Derrota
        }else if(palavra.completa()){
            return 2;//Vitoria
        }
        return 0;//Continua
    }

    public void exibirForca() {
        //exibe a palavra da forca que esta sendo adivinhada
        System.out.printf("Palavra: "+palavra.getPalavraForca()+" ");

        // pra cada letra dentro da lista escreva a letra
        System.out.printf("\nLetras informadas: ");
        for (String letra:letras) {
            System.out.printf(letra+" ");
        }

        //exibe quantas vidas faltam
        System.out.printf("\nTentativas restante: "+vida);
    }

    public boolean chuteLetra() {
        String letraDigitada;
        System.out.printf("\n\nDigite uma letra (0 para abandonar)> ");
        letraDigitada = scan.next();
        letraDigitada = letraDigitada.toLowerCase();
        letraDigitada = "" + letraDigitada.charAt(0);

        if("0".equals(letraDigitada)) return true;// Se for vercadeiro o usuario esta desistindo

        // /O usuario digitara a letra
        while(palavra.verificaLetraExiste(letraDigitada.charAt(0),letras)){
            System.out.printf("\nDigite uma outra letra> ");
            letraDigitada = scan.next();
        }

        letras.add(letraDigitada);
        vida -= palavra.executaLetra(letraDigitada);
        return false;
    }

    public void resultado(int status) {
        System.out.println("---------------------------------------------------");
        System.out.println("Você "+((status == 1)?"perdeu":((status == 3)?"Abandonou":"ganhou"))+" o jogo!");
        System.out.println("a palavra era: "+ palavra.getPalavra());
        if(status != 1)System.out.println("Você ainda tinha "+vida+" tentativas");
        System.out.println("---------------------------------------------------\n");

        //Atualiza o resultado do jogo no banco
        jogoDAO.salvarResultadoJogo(this,status);

    }

    //Dificuldade!

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
