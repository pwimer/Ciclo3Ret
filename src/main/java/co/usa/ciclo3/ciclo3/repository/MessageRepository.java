package co.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.repository.crud.MessageCrudRepository;
import co.usa.ciclo3.ciclo3.model.Message;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository MessageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) MessageCrudRepository.findAll();
    }

    public Optional<Message> getAuditorio(int id) {
        return MessageCrudRepository.findById(id);
    }

    public Message save(Message ms) {
        return MessageCrudRepository.save(ms);
    }
}
