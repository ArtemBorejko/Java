package store.repositories;

import org.springframework.data.jpa.repository.Query;
import store.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    void findByFullname(String fullname);
    @Query(value = "SELECT * FROM clients", nativeQuery = true)
    List<Client> findAllClients();
}
