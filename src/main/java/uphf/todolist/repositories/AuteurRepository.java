package uphf.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uphf.todolist.entities.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, String> {
}
