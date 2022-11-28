package api.extincao.animais.extincao.repositories;

import api.extincao.animais.extincao.models.Extinto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtintoRepository extends JpaRepository<Extinto, Long> {
}
