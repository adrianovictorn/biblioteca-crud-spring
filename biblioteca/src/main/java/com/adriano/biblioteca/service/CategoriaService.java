package com.adriano.biblioteca.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriano.biblioteca.model.Categoria;
import com.adriano.biblioteca.model.Livro;
import com.adriano.biblioteca.repository.CategoriaRepository;
import com.adriano.biblioteca.repository.LivroRepository;

@Service
public class CategoriaService {
    
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    LivroRepository livroRepository;

    public Categoria cadastrarCategoria (Categoria categoria){

        List<Livro> livrosAtualizados = categoria.getLivros().stream()
        .map(livro -> livroRepository.findById(livro.getId()).orElse(null))
        .filter(Objects::nonNull) 
        .collect(Collectors.toList());
    
        categoria.setLivros(livrosAtualizados);
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public void deletarCategoria(int id){
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        }
    }

    public Categoria atualizarCategoria(Categoria categoria){
        Categoria categoriaCadastrada = categoriaRepository.findById(categoria.getId()).orElse(null);
        if (categoriaCadastrada != null) {
            categoriaCadastrada.setNomeCategoria(categoria.getNomeCategoria());
            categoriaCadastrada.setLivros(categoria.getLivros());
            return categoriaRepository.save(categoriaCadastrada);
        }
        else{
            return null;
        }
    }
}
