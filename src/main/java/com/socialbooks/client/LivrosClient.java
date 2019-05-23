package com.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.socialbooks.client.domain.Autor;
import com.socialbooks.client.domain.Comentario;
import com.socialbooks.client.domain.Livro;

public class LivrosClient {
	
	public String uriLivro = "http://localhost:8080/livros/";
	public String uriAutor = "http://localhost:8080/autores/";
	private String key = "Basic bGl2cm9faXByYjpzM25oNA==";

	// POST do Autor
	public ResponseEntity<Autor> salvarAutor(Autor autor) {
		RequestEntity<Autor> request = RequestEntity
				.post(URI.create(uriAutor))
				.header("Authorization", key)
				.body(autor);
		
		ResponseEntity<Autor> response = new RestTemplate().exchange(request, Autor.class);
		
		return response;
	}
	
	// POST do Livro
	public ResponseEntity<Livro> salvarLivro(Livro livro) {
		RequestEntity<Livro> request = RequestEntity
				.post(URI.create(uriLivro))
				.header("Authorization", key)
				.body(livro);
		
		ResponseEntity<Livro> response = new RestTemplate().exchange(request, Livro.class);
		
		return response;
	}
	
	//POST do Comentario
	public ResponseEntity<Comentario> salvarComentario(Comentario comentario) {
		RequestEntity<Comentario> request = RequestEntity
				.post(URI.create(uriLivro + comentario.getLivro().getId() + "/comentarios"))
				.header("Authorization", key)
				.body(comentario);
		
		ResponseEntity<Comentario> response = new RestTemplate().exchange(request, Comentario.class);
		
		return response;
	}
	
	// Lista de livros cadastrados
	public List<Livro> listarLivro(){
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uriLivro))
				.header("Authorization", key)
				.build();
		
		ResponseEntity<Livro[]> response = new RestTemplate().exchange(request, Livro[].class);
		
		return Arrays.asList(response.getBody());
	}

}
