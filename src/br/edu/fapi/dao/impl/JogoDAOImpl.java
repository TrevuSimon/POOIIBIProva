package br.edu.fapi.dao.impl;

import br.edu.fapi.dao.JogoDAO;
import br.edu.fapi.dao.conexao.Connections;
import br.edu.fapi.jogo.Jogo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JogoDAOImpl implements JogoDAO {

	/*
		@Override
		public int cadastrarJogo(Jogo jogo) {
			return 0;
		}
	*/
	
	@Override
	public int salvarResultadoJogo(Jogo jogo, int Status) {
		return 0;
	}

	@Override
	public List<Jogo> listarJogo() {
		return null;
	}

	@Override
	public List<Jogo> listarJogoVitoria() {
		return null;
	}

	@Override
	public List<Jogo> listarJogoDerrota() {
		return null;
	}

	public int cadastrarJogo(Jogo jogo) {
		try (Connection connection = Connections.openConnection()) {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into funcionario_adv(jogador, dificuldade, inicio, fim, palavra_palpite, resultado) values (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, jogo.getJogador());
			preparedStatement.setString(2, jogo.getDificuldade());
			preparedStatement.setDate(3, (Date) jogo.getHoraJogo());
			preparedStatement.setDate(4, (Date) jogo.getHoraJogo());
			preparedStatement.setString(5, "teste");
			preparedStatement.setString(6, "teste");

			int resultado = preparedStatement.executeUpdate();
			System.out.println("Registro inserido");
			//// Obtém a pk gerada.
			ResultSet res = preparedStatement.getGeneratedKeys();
			if (res.first()) {
				System.out.println("Código gerado: " + res.getInt(1));
			}
			return resultado;
		} catch (SQLException e) {
			System.out.println("Conexão não estabelecida.");
			System.out.println(e.getMessage());
		}
		return 0;

	}
}