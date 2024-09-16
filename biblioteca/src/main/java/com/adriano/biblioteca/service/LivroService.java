package com.adriano.biblioteca.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriano.biblioteca.model.Autor;
import com.adriano.biblioteca.model.Categoria;
import com.adriano.biblioteca.model.Livro;
import com.adriano.biblioteca.repository.AutorRepository;
import com.adriano.biblioteca.repository.CategoriaRepository;
import com.adriano.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    AutorRepository autorRepository;
    
    public Livro adicionarLivro (Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    public void deletaLivro(int id){
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
        }
    }

    public Livro atualizarLivro (int id, Livro livroAtualizado){
        Livro livro= livroRepository.findById(id).orElse(null);
        if (livro != null) {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setDataPublicacao(livroAtualizado.getDataPublicacao());
            livro.setNomeAutor(livroAtualizado.getNomeAutor());
            livro.setCategoria(livroAtualizado.getCategoria());

            return livroRepository.save(livro);
        }
        else{
            return null;
        }
    }

}
