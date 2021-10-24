package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.repository.AuditorioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import co.usa.ciclo3.ciclo3.model.Auditorio;
import org.springframework.stereotype.Service;

@Service
public class AuditorioService {

    @Autowired
    private AuditorioRepository auditorioRepository;

    public List<Auditorio> getAll() {
        return auditorioRepository.getAll();

    }

    public Optional<Auditorio> getAuditorio(int id) {
        return auditorioRepository.getAuditorio(id);
    }

    public Auditorio save(Auditorio aud) {
        if (aud.getId() == null) {
            return auditorioRepository.save(aud);
        } else {
            Optional<Auditorio> paux = auditorioRepository.getAuditorio(aud.getId());
            if (paux.isEmpty()) {
                return auditorioRepository.save(aud);
            } else {
                return aud;
            }
        }
    }

}
