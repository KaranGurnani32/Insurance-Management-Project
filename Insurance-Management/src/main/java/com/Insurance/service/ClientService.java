package com.Insurance.service;

import com.Insurance.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    Client createClient(Client client);

    Client updateClient(Long id, Client client);

    boolean deleteClient(Long id);
}
