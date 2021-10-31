package co.usa.ciclo3.ciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.service.ClienteService;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ClienteControlador {

    @Autowired
    private ClienteService ClienteService;

    @GetMapping("/all")
    public List<Cliente> getClientes() {
        return ClienteService.getAll();
    }

    @GetMapping("/id")
    public Optional<Cliente> getAditorio(@PathVariable("id") int id) {
        return ClienteService.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cl) {
        return ClienteService.save(cl);
    }

}
