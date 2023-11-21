package uphf.todolist.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tache {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank
    private String titre;

    @Column(length = 100, nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    private Instant dateLimite;

    @ManyToOne
    private Auteur auteur;
}
