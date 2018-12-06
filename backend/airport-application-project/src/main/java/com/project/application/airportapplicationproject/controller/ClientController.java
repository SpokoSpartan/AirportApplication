package com.project.application.airportapplicationproject.controller;

import com.project.application.airportapplicationproject.DTOs.ClientDTO;
import com.project.application.airportapplicationproject.entities.Client;
import com.project.application.airportapplicationproject.services.ClientService;
import com.project.application.airportapplicationproject.utils.Mappings;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.API_VERSION + Mappings.CLIENT)
public class ClientController {

    private final ClientService clientService;

    @GetMapping(Mappings.GET_ALL)
    public MessageInfo getAllClients(){
        List<Client> clients = clientService.getAllClients();
        for(Client client : clients){
            Hibernate.initialize(client.getPerson());
        }
        return new MessageInfo(clients, true, Arrays.asList("List of clients"));
    }

    @GetMapping(Mappings.GET_ONE)
    public MessageInfo getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        Hibernate.initialize(client.getPerson());
        return new MessageInfo(client, true, Arrays.asList("Clint of ID = " + id.toString()));
    }

    @PostMapping(Mappings.CREATE)
    public MessageInfo createClient(@RequestBody @Valid ClientDTO clientDTO, BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return clientService.createClient(clientDTO);
    }

    @PostMapping(Mappings.UPDATE)
    public MessageInfo updateClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO,
                                     BindingResult bindingResult) {
        MessageInfo errors = MessageInfo.getErrors(bindingResult);
        if(errors != null)
            return errors;
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping(Mappings.REMOVE)
    public MessageInfo deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new MessageInfo(null, true, Arrays.asList("Client with id = " + id.toString() + "removed succesfully"));
    }
}