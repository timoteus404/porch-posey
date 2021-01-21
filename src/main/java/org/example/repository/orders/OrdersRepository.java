package org.example.repository.orders;

import org.example.entity.Orders;
import org.example.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
