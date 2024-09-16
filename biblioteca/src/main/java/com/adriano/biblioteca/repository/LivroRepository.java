package com.adriano.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.adriano.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro,Integer> {
}
