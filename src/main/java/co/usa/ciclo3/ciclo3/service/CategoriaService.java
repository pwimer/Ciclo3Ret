package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository CategoriaRepository;

    public List<Categoria> getAll() {
        return CategoriaRepository.getAll();
    }

    public Optional<Categoria> getCategoria(int id) {
        return CategoriaRepository.getAuditorio(id);
    }

    public Categoria save(Categoria ct) {
        if (ct.getId() == null) {
            return CategoriaRepository.save(ct);
        } else {
            Optional<Categoria> paux = CategoriaRepository.getAuditorio(ct.getId());
            if (paux.isEmpty()) {
                return CategoriaRepository.save(ct);
            } else {
                return ct;
            }
        }
    }
}
