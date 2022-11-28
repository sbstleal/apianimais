package api.extincao.animais.extincao.services;


import api.extincao.animais.extincao.models.Ameacado;
import api.extincao.animais.extincao.models.Extinto;
import api.extincao.animais.extincao.repositories.ExtintoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtintoService {
    @Autowired
    ExtintoRepository repository;

    public Extinto create(Extinto animal) {
        return repository.save(animal);
    }

    public List<Extinto> findAll() {
        return repository.findAll();
    }

    public Extinto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not Found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Extinto update(Long id, Extinto animal) {
        Extinto fromDataBase = this.findById(id);
        Util.myCopyProperties(animal, fromDataBase);
        this.repository.save(animal = fromDataBase);

        return animal;
    }
}
