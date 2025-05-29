package ru.porochov.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.porochov.tacocloud.model.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    TacoOrder save(TacoOrder order);
}
