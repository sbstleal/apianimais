package api.extincao.animais.extincao.repositories;

import api.extincao.animais.extincao.models.Ameacado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmeacadoRepository extends JpaRepository<Ameacado, Long> {
}
