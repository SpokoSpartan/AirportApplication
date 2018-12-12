package com.project.application.airportapplicationproject.services;

import com.project.application.airportapplicationproject.DTOs.ClientDTO;
import com.project.application.airportapplicationproject.entities.Client;

import com.project.application.airportapplicationproject.exceptions.ResourceNotFoundException;
import com.project.application.airportapplicationproject.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client"));
    }

    public Client createClient(ClientDTO clientDTO) {
        ModelMapper mapper = new ModelMapper();
        Client client = mapper.map(clientDTO, Client.class);
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client"));
        client.setPerson(clientDTO.getPerson());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("client"));
        clientRepository.delete(client);
    }
}