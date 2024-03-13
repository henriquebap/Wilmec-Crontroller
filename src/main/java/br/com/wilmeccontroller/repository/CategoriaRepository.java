package br.com.fiap.wilmeccontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cashflowpro.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
