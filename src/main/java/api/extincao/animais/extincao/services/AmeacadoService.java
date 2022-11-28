package api.extincao.animais.extincao.services;

import api.extincao.animais.extincao.models.Ameacado;
import api.extincao.animais.extincao.repositories.AmeacadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmeacadoService {
    @Autowired
    AmeacadoRepository repository;

    public Ameacado create(Ameacado animal) {
        return repository.save(animal);
    }

    public List<Ameacado> findAll() {
        return repository.findAll();
    }

    public Ameacado findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Ameacado update(Long id, Ameacado animal) {
        Ameacado fromDataBase = this.findById(id);
        Util.myCopyProperties(animal, fromDataBase);
        this.repository.save(animal = fromDataBase);

        return animal;
    }
}
