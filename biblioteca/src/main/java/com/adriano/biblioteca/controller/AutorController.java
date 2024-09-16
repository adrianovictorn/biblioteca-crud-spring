package com.adriano.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.adriano.biblioteca.model.Autor;
import com.adriano.biblioteca.model.Livro;
import com.adriano.biblioteca.service.AutorService;


@RestController
@RequestMapping("/autor")
public class AutorController {
    
    @Autowired
    AutorService autorService;

    @PostMapping
    public Autor cadastrarAutor(@RequestBody Autor autor){
        return autorService.adicionarAutor(autor);
    }

    @PostMapping("/{autorId}/livro/{livroId}")
    public ResponseEntity<Autor> adicionarLivroAoAutor(@PathVariable int autorId, @PathVariable int livroId) {
        Autor autorAtualizado = autorService.adicionarLivroAoAutor(autorId, livroId);
        return new ResponseEntity<>(autorAtualizado, HttpStatus.OK);
    }


    @GetMapping
    public List<Autor> listarAutores(){
        return autorService.listarAutores();
    }

    @GetMapping("/{id}/livros")
    public ResponseEntity<List<Livro>> listarLivrosPorAutor(@PathVariable int id) {
        List<Livro> livros = autorService.listarLivrosPorAutor(id);
        return ResponseEntity.ok(livros);
    }

    @PutMapping
    public Autor atualizAutor(@RequestBody Autor autor){
        return autorService.atualizarAutor(autor);
    }
    
    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable int id){
        autorService.deletarAutor(id);
    }
}
