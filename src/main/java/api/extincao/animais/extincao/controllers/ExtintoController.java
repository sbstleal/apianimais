package api.extincao.animais.extincao.controllers;

import api.extincao.animais.extincao.models.Extinto;
import api.extincao.animais.extincao.services.ExtintoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extinto")
public class ExtintoController {
    @Autowired
    ExtintoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Inclui o registro de dados de um animal extinto")
    public ResponseEntity<Extinto> create(@RequestBody Extinto animal) {
        Extinto created = service.create(animal);

        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Retorna uma lista de dados de animais extintos")
    public List<Extinto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Retorna dados de um animal extinto de acordo com o seu ID de cadastro")
    public Extinto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Exclui o registro de dados de um animal extinto por seu ID de cadastro")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Atualiza informações do registro de um animal extinto")
    public ResponseEntity<Extinto> update(@PathVariable Long id, @RequestBody Extinto animal) {
        return ResponseEntity.accepted().body(this.service.update(id, animal)).status(200).body(animal);
    }
}
