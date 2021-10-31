package co.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.repository.crud.CategoriaCrudRepository;
import co.usa.ciclo3.ciclo3.model.Categoria;

@Repository
public class CategoriaRepository {

    @Autowired
    private CategoriaCrudRepository CategoriaCrudRepository;

    public List<Categoria> getAll() {
        return (List<Categoria>) CategoriaCrudRepository.findAll();
    }

    public Optional<Categoria> getAuditorio(int id) {
        return CategoriaCrudRepository.findById(id);
    }

    public Categoria save(Categoria ct) {
        return CategoriaCrudRepository.save(ct);
    }

}
