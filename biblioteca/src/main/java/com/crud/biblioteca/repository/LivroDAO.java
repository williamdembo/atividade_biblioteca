package com.crud.biblioteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.crud.biblioteca.connection.Conexao;
import com.crud.biblioteca.model.*;

public class LivroDAO {
	private List<Livro> livros;
	
	public LivroDAO() {
		livros = new ArrayList<>();
	}
	
	// CREATE
	public void inserir(Livro livro) {
        livros.add(livro);
        System.out.println("Livro inserido: " + livro.getTitulo());
    }
	
	// READ
	private static final String SQL_BUSCAR_TODOS =
			"SELECT id, titulo, autor, data_lancamento, edicao, numero_paginas FROM livro ORDER BY id";
	public List<Livro> buscarTodos(){
		List<Livro> lista = new ArrayList<>();
		try (
				Connection conn = Conexao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_BUSCAR_TODOS);
				ResultSet rs = stmt.executeQuery()
			) {
				while (rs.next()) {
					lista.add(mapear(rs));
				}
			}catch (SQLException e) {
				throw new RuntimeException ("Erro ao buscar livros:" + 
			e.getMessage(), e);
			}
		return lista;
	}
	
	private static final String SQL_BUSCAR_POR_ID =
			"SELECT id, titulo, autor, data_lancamento, edicao, numero_paginas FROM livro WHERE id = ?";
	public Optional<Livro> buscarPorId(int id){
		try (
				Connection conn = Conexao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_BUSCAR_POR_ID);
			) {
				stmt.setInt(1, id);
				
				try (ResultSet rs = stmt.executeQuery()){
					if(rs.next()) {
						return Optional.of(mapear(rs));
					}
				}
			}catch (SQLException e) {
				throw new RuntimeException ("Erro ao buscar livro com id = " + 
			e.getMessage(), e);
			}
		return Optional.empty();
	}
	
	
	private Livro mapear (ResultSet rs) throws SQLException {
		return new Livro(
				rs.getInt("id"),
				rs.getString("titulo"),
				rs.getString("autor"),
				rs.getString("data_lancamento"),
				rs.getInt("edicao"),
				rs.getInt("numero_paginas")
		);
	}
	
	// UPDATE
	
	
}
