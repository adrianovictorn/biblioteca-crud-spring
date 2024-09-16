package com.adriano.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.adriano.biblioteca.model.Categoria;


public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{
    
}
