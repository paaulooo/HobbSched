package com.paledev.hobbsched.services;

import com.paledev.hobbsched.dto.ClientDTO;
import com.paledev.hobbsched.models.Client;
import com.paledev.hobbsched.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client save(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        return clientRepository.save(client);
    }
    public Client update(Long id, ClientDTO dto) {
        Client client = clientRepository.findById(id).orElseThrow(()
            -> new RuntimeException("Client with id " + id + " not found!"));
        client.setName(dto.getName());
        return clientRepository.save(client);
    }
    public void delete(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()
            -> new RuntimeException("Client with id " + id + " not found!"));
        clientRepository.delete(client);
    }

    public List<Client> findAll() { return  clientRepository.findAll(); }
    public Client findById(Long id) { return clientRepository.findById(id).get(); }


}
