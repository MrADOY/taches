package uphf.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uphf.todolist.entities.Tache;
import uphf.todolist.services.exception.EntityNonTrouveeException;
import uphf.todolist.services.taches.TachesService;
import uphf.todolist.services.taches.odt.CreerTachePayload;

import java.util.List;

@RestController
@RequestMapping("taches")
public class TacheController {

    @Autowired
    TachesService tachesService;

    @GetMapping
    public ResponseEntity<List<Tache>> recupererListeTaches() {
        return ResponseEntity.ok(this.tachesService.recupererListeTaches());
    }

    @GetMapping("{id}")
    public ResponseEntity<Tache> recupererDetailTache(@PathVariable("id") String id) {
        try {
            // Je recherche ma tache à l'aide de mon service
            return ResponseEntity.ok(this.tachesService.recupererDetailTache(id));
        } catch (EntityNonTrouveeException e) {
            // Quand mon traitement est arrêté à cause d'une EntityNonTrouveeException
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity creerTache(@RequestBody CreerTachePayload creerTachePayload) {
        try {
            return ResponseEntity.ok(this.tachesService.creerTache(creerTachePayload));
        } catch (EntityNonTrouveeException e) {
            return ResponseEntity.internalServerError().body("Auteur non trouvée");
        }
    }
}
