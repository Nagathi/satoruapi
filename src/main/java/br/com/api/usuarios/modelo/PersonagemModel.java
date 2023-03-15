package br.com.api.usuarios.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="personagens")
@Getter
@Setter
public class PersonagemModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String anime;

}
