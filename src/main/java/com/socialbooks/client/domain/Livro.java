package com.socialbooks.client.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Livro {

	private Long id;

	private String nome;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date publicado;

	private String editora;

	private String resumo;

	private List<Comentario> comentarios;

	private Autor autor;

	// construtores da classe
	public Livro() {
	}; // default

	public Livro(String nome, String editora, Autor autor) {
		this.nome = nome;
		this.editora = editora;
		this.autor = autor;
	};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPublicado() {
		return publicado;
	}

	public void setPublicado(Date publicado) {
		this.publicado = publicado;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

}
