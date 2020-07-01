package deoliveira.vinicius.injusticeapi.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @Author Vinícius de Oliveira
 * @Version 1.0
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

@Component

@Entity
@Table(name = "personagem")
public class PersonagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personagem")
    private long id;

    @NotBlank(message = "Não são permitidos valores vazios.")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "Não são permitidos valores vazios.")
    @Column(name = "descricao")
    private String descricao;

    @NotBlank(message = "Não são permitidos valores vazios.")
    @Column(name = "habilidade")
    private String habilidade;

    @Column(name = "forca")
    private int forca;

    @Column(name = "defesa")
    private int defesa;

}
