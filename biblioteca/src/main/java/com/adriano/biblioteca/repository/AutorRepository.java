package com.adriano.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adriano.biblioteca.model.Autor;


public interface AutorRepository extends JpaRepository<Autor, Integer> {
}