package com.socialbooks.aplicacao;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Aplicacao {

	public static void main(String[] args) {
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/livros"))
				.header("Authorization", "Basic bGl2cm9faXByYjpzM25oNA==")
				.build();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Livro[]> response = restTemplate.exchange(request, Livro[].class);
		
		for(Livro livro:response.getBody()) {
			System.out.println("Livro:"+livro.getNome());
			System.out.println("Autor:"+livro.getAutor().getNome());
		}
		
	}

}
