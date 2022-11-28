package api.extincao.animais.extincao.controllers;

import api.extincao.animais.extincao.models.Ameacado;
import api.extincao.animais.extincao.models.Extinto;
import api.extincao.animais.extincao.services.AmeacadoService;
import api.extincao.animais.extincao.services.ExtintoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ameacado")
public class AmeacadoController {
    @Autowired
    AmeacadoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Inclui o registro de dados de um animal ameaçado de extinção")
    public ResponseEntity<Ameacado> create(@RequestBody Ameacado animal) {
        Ameacado created = service.create(animal);

        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Retorna uma lista de dados de animais ameaçados de extinção")
    public List<Ameacado> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Retorna dados de um animal ameaçado de extinção de acordo com o seu ID de cadastro")
    public Ameacado findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Exclui o registro de dados de um animal ameaçado de extinção por seu ID de cadastro")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Atualiza informações do registro de um animal ameaçado de extinção")
    public ResponseEntity<Ameacado> update(@PathVariable Long id, @RequestBody Ameacado animal) {
        return ResponseEntity.accepted().body(this.service.update(id, animal)).status(200).body(animal);
    }
}
