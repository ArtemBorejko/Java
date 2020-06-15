package store.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import store.entities.Worker;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Integer> {
    @Query(value = "SELECT * FROM workers", nativeQuery = true)
    List<Worker> findAllWorkers();
}
