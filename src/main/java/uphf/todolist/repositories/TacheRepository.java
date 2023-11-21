package uphf.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uphf.todolist.entities.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, String> {
}
