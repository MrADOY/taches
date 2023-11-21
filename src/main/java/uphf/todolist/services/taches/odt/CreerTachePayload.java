package uphf.todolist.services.taches.odt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreerTachePayload {
    private String titre;
    private String description;
    private String dateLimite;
    private String idAuteur;
}
