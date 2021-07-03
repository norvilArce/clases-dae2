package pe.isil.service;

import java.util.List;

public interface BaseService<C, ID> {

    void create(C c);
    C read(ID id);
    void update(C c);
    void delete(ID id);

    List<C> getAll();
}
