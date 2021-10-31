package co.usa.ciclo3.ciclo3.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.usa.ciclo3.ciclo3.model.Reservacion;
import co.usa.ciclo3.ciclo3.repository.ReservacionRepository;

@Service
public class ReservacionService {

    @Autowired
    private ReservacionRepository ReservacionRepository;

    public List<Reservacion> getAll() {
        return ReservacionRepository.getAll();
    }

    public Optional<Reservacion> getReservacion(int id) {
        return ReservacionRepository.getAuditorio(id);
    }

    public Reservacion save(Reservacion rs) {
        if (rs.getIdReservation() == null) {
            return ReservacionRepository.save(rs);
        } else {
            Optional<Reservacion> paux = ReservacionRepository.getAuditorio(rs.getIdReservation());
            if (paux.isEmpty()) {
                return ReservacionRepository.save(rs);
            } else {
                return rs;
            }
        }
    }

}
