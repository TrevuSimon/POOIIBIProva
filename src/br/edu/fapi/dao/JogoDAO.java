package br.edu.fapi.dao;

import br.edu.fapi.jogo.Jogo;

import java.util.List;

public interface JogoDAO {

    int cadastrarJogo(Jogo jogo);

    int salvarResultadoJogo(Jogo jogo, int Status);

    List<Jogo> listarJogo();

    List<Jogo> listarJogoVitoria();

    List<Jogo> listarJogoDerrota();

	List<Jogo> listarJogo();

	List<Jogo> listarJogoVitoria();

	List<Jogo> listarJogoDerrota();


}
