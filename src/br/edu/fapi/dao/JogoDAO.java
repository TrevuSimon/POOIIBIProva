package br.edu.fapi.dao;

import br.edu.fapi.jogo.Jogo;

import java.util.List;

public interface JogoDAO {

    int cadastrarJogo(Jogo jogo);

    int salvarResultadoJogo(Jogo jogo, int Status);

    List<Jogo> listarJogo(Jogo jogo);

    List<Jogo> listarJogoVitoria(Jogo jogo);

    List<Jogo> listarJogoDerrota(Jogo jogo);

}
