package br.com.wilmeccontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wilmeccontroller.model.Categoria;
import br.com.wilmeccontroller.model.Fluxo;
import jakarta.validation.Valid;

public interface FluxoRepository extends JpaRepository<Categoria, Long> {

    Fluxo save(@Valid Fluxo fluxo);

}
