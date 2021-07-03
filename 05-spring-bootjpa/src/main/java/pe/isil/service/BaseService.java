package pe.isil.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<C, K> {

    public Optional<C> findById(K k);
    public Optional<List<C>> findAll();

    public C saveOrUpdate(C c);

    public boolean deleteById(K k);

}
