package com.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.socialbooks.client.LivrosClient;
import com.socialbooks.client.domain.Autor;
import com.socialbooks.client.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		LivrosClient cliente = new LivrosClient();
		List<Livro> listaLivros = cliente.listarLivro();
		
		for(Livro livro:listaLivros) {
			System.out.println("Livro:"+livro.getNome());
			System.out.println("Autor:"+livro.getAutor().getNome());
		}
		
		Autor autor = new Autor();
		autor.setNome("Alexandre Jr.");
		autor.setNacionalidade("Brasileiro");
		autor.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
		String localAutor = cliente.salvarAutor(autor);
		System.out.println("URI da localizacao do recurso salvo: "+localAutor);
		
		Livro livro = new Livro();
		livro.setNome("Git passo-a-passo");
		livro.setEditora("Editora Teste");
		livro.setPublicado(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
		livro.setResumo("Este livro trata-se de desenvolvimento de API's");
		String localLivro = cliente.salvarLivro(livro);
		System.out.println("URI da localizacao do recurso salvo: "+localLivro);
		
		
		
		
	}
}
