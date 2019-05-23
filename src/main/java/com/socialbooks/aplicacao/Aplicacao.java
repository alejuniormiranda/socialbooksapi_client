package com.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.socialbooks.client.LivrosClient;
import com.socialbooks.client.domain.Autor;
import com.socialbooks.client.domain.Comentario;
import com.socialbooks.client.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {

		LivrosClient cliente = new LivrosClient();

		// Criar Autor
		Autor autor = new Autor();
		autor.setNome("Alexandre Jr.");
		autor.setNacionalidade("Brasileiro");
		autor.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
		ResponseEntity<Autor> responseAutor = cliente.salvarAutor(autor);
		autor = responseAutor.getBody();
		String uriAutor = responseAutor.getHeaders().getLocation().toString();
		System.out.println("URI da localizacao do Autor salvo: " + uriAutor);

		// Criar Livro
		Livro livro = new Livro();
		livro.setNome("Git passo-a-passo");
		livro.setEditora("Editora Teste");
		livro.setPublicado(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
		livro.setResumo("Este livro trata-se de desenvolvimento de API's");
		livro.setAutor(autor);
		ResponseEntity<Livro> responseLivro = cliente.salvarLivro(livro);
		livro = responseLivro.getBody();
		String uriLivro = responseLivro.getHeaders().getLocation().toString();
		System.out.println("URI da localizacao do Livro salvo: " + uriLivro);

		// Criar Comentário
		Comentario comentario = new Comentario();
		comentario.setTexto("Muito bom este livro. Recomendadíssimo!");
		comentario.setLivro(livro);
		ResponseEntity<Comentario> responseComentario = cliente.salvarComentario(comentario);
		comentario = responseComentario.getBody();
		String uriComentario = responseComentario.getHeaders().getLocation().toString();
		System.out.println("URI da localizacao do Comentario salvo: " + uriComentario);

		// Listar Livros
		List<Livro> listaLivros = cliente.listarLivro();
		for (Livro livroList : listaLivros) {
			System.out.println("-------------------------------------");
			System.out.println("Livro: " + livroList.getNome());
			System.out.println("Autor: " + livroList.getAutor().getNome());
			System.out.println("Comentarios: " + livroList.getComentarios().get(0).getTexto());
		}

	}
}
