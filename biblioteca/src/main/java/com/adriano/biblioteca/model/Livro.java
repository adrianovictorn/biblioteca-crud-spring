package com.adriano.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;


@Entity
public class Livro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;


    private String titulo;
    

    private String editora;
    
    private LocalDate dataPublicacao;

    

    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores = new ArrayList<>();;

    @ManyToMany
    private List<Categoria> categoria = new ArrayList<>();;

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Autor> getNomeAutor() {
        return autores;
    }

    public void setNomeAutor(List<Autor> nomeAutor) {
        this.autores = nomeAutor;
    }
}
