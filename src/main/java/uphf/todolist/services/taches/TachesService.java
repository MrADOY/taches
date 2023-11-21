package uphf.todolist.services.taches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uphf.todolist.entities.Auteur;
import uphf.todolist.entities.Tache;
import uphf.todolist.repositories.AuteurRepository;
import uphf.todolist.repositories.TacheRepository;
import uphf.todolist.services.exception.EntityNonTrouveeException;
import uphf.todolist.services.taches.odt.CreerTachePayload;
import uphf.todolist.services.taches.odt.CreerTacheResponse;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Service
public class TachesService {

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private AuteurRepository auteurRepository;


    public CreerTacheResponse creerTache(CreerTachePayload creerTachePayload) {

        Optional<Auteur> auteurOptional = this.auteurRepository.findById(creerTachePayload.getIdAuteur());

        Tache tacheAEnregistrer = Tache.builder()
                .titre(creerTachePayload.getTitre())
                .dateLimite(Instant.parse(creerTachePayload.getDateLimite()))
                .description(creerTachePayload.getDescription())
                .auteur(auteurOptional.orElseThrow(() -> new EntityNonTrouveeException()))
                .build();

        Tache tacheSauvegardeeEnBase = this.tacheRepository.save(tacheAEnregistrer);

        return CreerTacheResponse.builder().id(String.valueOf(tacheSauvegardeeEnBase.getId())).build();
    }

    public List<Tache> recupererListeTaches() {
        return this.tacheRepository.findAll();
    }

    public Tache recupererDetailTache(String id) {
        Optional<Tache> tacheOptional = this.tacheRepository.findById(id);
        // Un optional est un objet Java permettant d'éviter d'utiliser les null
        // Si ma tache est trouvée elle est retournée
        // Sinon on arrête le traitement à l'aide d'une EntityNonTrouveeException
        return tacheOptional.orElseThrow(() ->  new EntityNonTrouveeException());
    }
}
