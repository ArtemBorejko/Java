package store.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import store.entities.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    @Query(value = "SELECT * FROM items", nativeQuery = true)
    List<Item> findAllItems();
}
