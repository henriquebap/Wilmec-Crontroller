package br.com.wilmeccontroller.controller;

import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;

import br.com.wilmeccontroller.model.Fluxo;
import br.com.wilmeccontroller.repository.FluxoRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("fluxo")
public class FluxoController {
    @Autowired
    FluxoRepository repository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Fluxo create(@RequestBody @Valid Fluxo fluxo) {
        return repository.save(fluxo);
    }

}
