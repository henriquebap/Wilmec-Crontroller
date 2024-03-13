package br.com.wilmeccontroller.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wilmeccontroller.model.Categoria;
import br.com.wilmeccontroller.repository.CategoriaRepository;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    Logger log = (Logger) LoggerFactory.getLogger(getClass());

//    List<Categoria> repository = new ArrayList<>();

    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        log.info("Cadastrando Categoria: {}", categoria);
        repository.add(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
        log.info("Buscando Categoria com id: {}", id);

        var categoria = getCategoriaById(id);

        if (categoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria.get());
    }

    private Optional<Categoria> getCategoriaById(Long id) {
        var categoria = repository
                .stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
        return categoria;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("Apagando Categoria {} ", id);

        var categoria = getCategoriaById(id);

        if (categoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.remove(categoria.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> update(
            @PathVariable Long id,
            @RequestBody Categoria categoria) {
        log.info("Atualizando categoria com id {} para {}", id, categoria);

        var categoria_encontrada = getCategoriaById(id);

        if (categoria_encontrada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var categoria_atualizada = new Categoria(id, categoria.nome_prod(), categoria.descricao_prod(), null, null, 0);

        repository.remove(categoria_encontrada.get());

        repository.add(categoria_atualizada);

        return ResponseEntity.ok(categoria_atualizada);
    }
}
