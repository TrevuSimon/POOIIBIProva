package br.edu.fapi.dao;

import br.edu.fapi.jogo.Jogo;

public interface JogoDAO {

    int cadastrarJogo(Jogo jogo);

    int salvarResultadoJogo(Jogo jogo, int Status);
}
