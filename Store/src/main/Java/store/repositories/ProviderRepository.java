package store.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import store.entities.Provider;

import java.util.List;


public interface ProviderRepository extends CrudRepository<Provider, Integer> {
    @Query(value = "SELECT * FROM providers", nativeQuery = true)
    List<Provider> findAllProviders();
}
