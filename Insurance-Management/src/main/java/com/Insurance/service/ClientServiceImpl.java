package com.Insurance.service;

import com.Insurance.model.Client;
import com.Insurance.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new IllegalArgumentException("Client not found for id: " + id);
        }
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setName(clientDetails.getName());
            client.setAddress(clientDetails.getAddress());
            client.setContactInfo(clientDetails.getContactInfo());
            return clientRepository.save(client);
        } else {
            throw new IllegalArgumentException("Client not found for id: " + id);
        }
    }

    @Override
    public boolean deleteClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
            return true;
        } else {
            throw new IllegalArgumentException("Client not found for id: " + id);
        }
    }
}
