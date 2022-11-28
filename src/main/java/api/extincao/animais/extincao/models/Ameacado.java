package api.extincao.animais.extincao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="anm_ameacados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ameacado {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String grupo_taxonomico;
    private String classe;
    private String ordem;
    private String familia;
    private String especie;
    private String nome_comum;
    private String categoria_validada;
    private String criterio_validado;
    private String regiao;
    private String justificativa;
}
