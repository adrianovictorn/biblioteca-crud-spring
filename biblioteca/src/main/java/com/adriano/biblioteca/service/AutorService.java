package com.adriano.biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adriano.biblioteca.model.Autor;
import com.adriano.biblioteca.model.Livro;
import com.adriano.biblioteca.repository.AutorRepository;
import com.adriano.biblioteca.repository.LivroRepository;

@Service
public class AutorService {

     @Autowired
    LivroRepository livroRepository;
    
    @Autowired
    AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    public List<Autor> listarAutores (){
        return autorRepository.findAll();
    }
    

    public List<Livro> listarLivrosPorAutor(int autorId){
        Autor autor = autorRepository.findById(autorId).orElse(null);
        return autor.getLivros();
    }
    public Autor adicionarAutor(Autor autor){
        return autorRepository.save(autor);
    }

      public Autor adicionarLivroAoAutor(int autorId, int livroId) {
        Autor autor = autorRepository.findById(autorId).orElseThrow();
        Livro livro = livroRepository.findById(livroId).orElseThrow();

        autor.getLivros().add(livro);
        livro.getNomeAutor().add(autor);

        return autorRepository.save(autor);
    }

    public Autor atualizarAutor(Autor autor){
        Autor autorCadastrado = autorRepository.findById(autor.getId()).orElse(null);
        if (autorCadastrado != null) {
            autorCadastrado.setLivros(autor.getLivros());
            autorCadastrado.setNomeAutor(autor.getNomeAutor());
            autorCadastrado.setDataNascimento(autor.getDataNascimento());
            
            return autorRepository.save(autorCadastrado);
        }
        else{
            return null;
        }
    }
  
    public void deletarAutor(int id){
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
        }
    }
}
