package co.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.repository.crud.ReservacionCrudRepository;
import co.usa.ciclo3.ciclo3.model.Reservacion;

@Repository
public class ReservacionRepository {

    @Autowired
    private ReservacionCrudRepository ReservacionCrudRepository;

    public List<Reservacion> getAll() {
        return (List<Reservacion>) ReservacionCrudRepository.findAll();
    }

    public Optional<Reservacion> getAuditorio(int id) {
        return ReservacionCrudRepository.findById(id);
    }

    public Reservacion save(Reservacion rs) {
        return ReservacionCrudRepository.save(rs);
    }

}
