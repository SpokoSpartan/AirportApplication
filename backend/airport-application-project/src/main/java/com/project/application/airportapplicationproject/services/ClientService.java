package com.project.application.airportapplicationproject.services;

import com.project.application.airportapplicationproject.DTOs.ClientDTO;
import com.project.application.airportapplicationproject.entities.Client;

import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.ClientRepository;
import com.project.application.airportapplicationproject.utils.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    Logger logger = Logger.getLogger(getClass().getName());

    public List<Client> getAllClients() {

        logger.info("jesem");

        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client"));
    }

    public MessageInfo createClient(ClientDTO clientDTO) {
        ModelMapper mapper = new ModelMapper();
        Client client = mapper.map(clientDTO, Client.class);
        return saveClient(client, "Client created successfully");
    }

    public MessageInfo updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client"));
        client.setPerson(clientDTO.getPerson());
        return saveClient(client, "Client with ID = " + id.toString() + " updated successfully");
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client"));
        clientRepository.delete(client);
    }

    private MessageInfo saveClient(Client client, String defaultMessage){
        try {
            client = clientRepository.save(client);
        }
        catch (ConstraintViolationException exc){
            return MessageInfo.getErrors(exc);
        }
        return new MessageInfo(client, true, Arrays.asList(defaultMessage));
    }
}