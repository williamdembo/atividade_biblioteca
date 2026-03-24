package com.crud.biblioteca;

import java.util.List;
import java.util.Optional;

import com.crud.biblioteca.model.*;
import com.crud.biblioteca.repository.*;

public class Main {
	public static void main(String[] agrs) {
		
		LivroDAO dao = new LivroDAO();
	/*	
		System.out.println("==== SELECT ALL ====");
		
		List<Livro> todos = dao.buscarTodos();
		todos.forEach(System.out::println);
	*/
		Optional<Livro> encontrado = dao.buscarPorId(1);
		encontrado.ifPresentOrElse(a -> System.out.prinln("encontrado "+a),
								  () -> System.out.println("Livro não encontrado"));
	}
}
