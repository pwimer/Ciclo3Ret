package co.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.repository.crud.ClienteCrudRepository;
import co.usa.ciclo3.ciclo3.model.Cliente;

@Repository
public class ClienteRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> getAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    public Optional<Cliente> getAuditorio(int id) {
        return clienteCrudRepository.findById(id);
    }

    public Cliente save(Cliente cl) {
        return clienteCrudRepository.save(cl);
    }

}
