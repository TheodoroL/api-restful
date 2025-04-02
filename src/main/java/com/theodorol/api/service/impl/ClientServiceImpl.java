package com.theodorol.api.service.impl;

import com.theodorol.api.model.Client;
import com.theodorol.api.repository.ClientRepository;
import com.theodorol.api.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client findById(Long id) {
        return repository.findById(id).orElseThrow((NoSuchElementException::new));
    }

    @Override
    public Client create(Client client) {
        if(repository.existByAccountNumber(client.getAccount().getNumber())){
            throw  new IllegalArgumentException("O usuário já existe");
        }
        return repository.save(client);
    }
}
