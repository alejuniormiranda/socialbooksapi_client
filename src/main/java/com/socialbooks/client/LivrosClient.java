package com.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.socialbooks.client.domain.Autor;
import com.socialbooks.client.domain.Comentario;
import com.socialbooks.client.domain.Livro;

public class LivrosClient {
	
	private RestTemplate restTemplate;
	private String uriBase;
	private String credencialAuth;
	
	public LivrosClient(String url, String usuario, String senha) {
		restTemplate = new RestTemplate();
		this.uriBase = url;
		String credencial = usuario + ":" + senha;
		credencialAuth = "Basic " + Base64.getEncoder().encodeToString(credencial.getBytes());
	}
	

	// POST do Autor
	public ResponseEntity<Autor> salvarAutor(Autor autor) {
		RequestEntity<Autor> request = RequestEntity
				.post(URI.create(uriBase + "/autores"))
				.header("Authorization", credencialAuth)
				.body(autor);
		
		ResponseEntity<Autor> response = restTemplate.exchange(request, Autor.class);
		
		return response;
	}
	
	// POST do Livro
	public ResponseEntity<Livro> salvarLivro(Livro livro) {
		RequestEntity<Livro> request = RequestEntity
				.post(URI.create(uriBase + "/livros"))
				.header("Authorization", credencialAuth)
				.body(livro);
		
		ResponseEntity<Livro> response = restTemplate.exchange(request, Livro.class);
		
		return response;
	}
	
	//POST do Comentario
	public ResponseEntity<Comentario> salvarComentario(Comentario comentario) {
		RequestEntity<Comentario> request = RequestEntity
				.post(URI.create(uriBase + "/livros/" + comentario.getLivro().getId() + "/comentarios"))
				.header("Authorization", credencialAuth)
				.body(comentario);
		
		ResponseEntity<Comentario> response = restTemplate.exchange(request, Comentario.class);
		
		return response;
	}
	
	// Lista de livros cadastrados
	public List<Livro> listarLivro(){
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uriBase + "/livros"))
				.header("Authorization", credencialAuth)
				.build();
		
		ResponseEntity<Livro[]> response = restTemplate.exchange(request, Livro[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	// Lista um livro específico
	public Livro buscarLivro(Long id) {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uriBase + "/livros/" + id))
				.header("Authorization", credencialAuth)
				.build();
		
		ResponseEntity<Livro> response = restTemplate.exchange(request, Livro.class);
		
		return response.getBody();
	}

}
