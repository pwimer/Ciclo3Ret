package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository MessageRepository;

    public List<Message> getAll() {
        return MessageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return MessageRepository.getAuditorio(id);
    }

    public Message save(Message ms) {
        if (ms.getIdMessage() == null) {
            return MessageRepository.save(ms);
        } else {
            Optional<Message> paux = MessageRepository.getAuditorio(ms.getIdMessage());
            if (paux.isEmpty()) {
                return MessageRepository.save(ms);
            } else {
                return ms;
            }
        }
    }

}
