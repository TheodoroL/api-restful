package com.theodorol.api.service;

import com.theodorol.api.model.Client;

public interface ClientService {
    Client findById(Long id);

    Client create(Client client);

}
