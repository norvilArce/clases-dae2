package pe.isil.repository;

import java.util.List;

public interface BaseRepository<C, ID> {

    void create(C c);
    C read(ID id);
    void update(C c);
    void delete(ID id);

    List<C> getAll();
}
