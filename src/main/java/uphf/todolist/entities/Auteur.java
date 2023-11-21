package uphf.todolist.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Auteur {
    @Id
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank
    private String nom;

    @Column(length = 100, nullable = false)
    @NotBlank
    private String prenom;

    @OneToMany(mappedBy = "auteur")
    private List<Tache> taches;
}
