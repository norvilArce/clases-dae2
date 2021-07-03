package pe.isil.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<C, K> {
    C createOrUpdate(C c);
    boolean deleteById(K k);
    Optional<C> findById(K k);
    Optional<List<C>> findAll();
}
