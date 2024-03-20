package br.com.wilmeccontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wilmeccontroller.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
