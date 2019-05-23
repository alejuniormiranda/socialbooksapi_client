package com.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.socialbooks.client.domain.Autor;
import com.socialbooks.client.domain.Livro;

public class LivrosClient {
	
	private String uriLivro = "http://localhost:8080/livros";
	private String uriAutor = "http://localhost:8080/autores";
	private String autorizacao = "\"Authorization\", \"Basic bGl2cm9faXByYjpzM25oNA==\"";

	public List<Livro> listarLivro(){
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uriLivro))
				.header(autorizacao)
				.build();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Livro[]> response = restTemplate.exchange(request, Livro[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvarAutor(Autor autor) {
		RequestEntity<Autor> request = RequestEntity
				.post(URI.create(uriAutor))
				.header(autorizacao)
				.body(autor);
		
		ResponseEntity<Void> response = new RestTemplate().exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	public String salvarLivro(Livro livro) {
		RequestEntity<Livro> request = RequestEntity
				.post(URI.create(uriLivro))
				.header(autorizacao)
				.body(livro);
		
		ResponseEntity<Void> response = new RestTemplate().exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
}
