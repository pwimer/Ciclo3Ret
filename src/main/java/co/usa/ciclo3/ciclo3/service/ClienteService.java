package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.getAll();
    }

    public Optional<Cliente> getCliente(int id) {
        return clienteRepository.getAuditorio(id);
    }

    public Cliente save(Cliente cl) {
        if (cl.getIdClient() == null) {
            return clienteRepository.save(cl);
        } else {
            Optional<Cliente> paux = clienteRepository.getAuditorio(cl.getIdClient());
            if (paux.isEmpty()) {
                return clienteRepository.save(cl);
            } else {
                return cl;
            }
        }
    }

}
