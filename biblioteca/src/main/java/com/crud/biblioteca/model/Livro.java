package com.crud.biblioteca.model;

public class Livro {
	private Integer id;
	private String titulo;
	private String autor;
	private String dataLancamento;
	private Integer edicao;
	private Integer numeroPaginas;
	
	public Livro() {}
	
	public Livro(Integer id, String titulo, String autor, String dataLancamento, Integer edicao, Integer numeroPaginas) {
        super();
		this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
    }
	
	public Livro(String titulo, String autor, String dataLancamento, Integer edicao, Integer numeroPaginas) {
        super();
		this.titulo = titulo;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
    }
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	
	public String getAutor() { return autor; }
	public void setAutor(String autor) { this.autor = autor; }
	
	public String gatDataLancamento() { return dataLancamento; }
	public void setDataLancameento(String dataLancamento) { this.dataLancamento = dataLancamento; }
	
	public int getEdicao() { return edicao;	}
	public void setEdicao(int edicao) { this.edicao = edicao; }
	
	public int getNumeroPaginas() { return numeroPaginas; }
	public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }
}
