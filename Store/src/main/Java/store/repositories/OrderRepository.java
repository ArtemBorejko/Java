package store.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import store.entities.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    List<Order> findAllOrders();
}
