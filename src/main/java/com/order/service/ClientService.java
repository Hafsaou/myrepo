package com.order.service;


import com.order.model.Client;
import com.order.model.Product;
import com.order.repo.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final WebClient webClient;
    public List<Client> getAllClients() {

       webClient.get()
                .uri("http://localhost:8083/api/products")
                .retrieve()
                .bodyToFlux(Product.class).toStream().forEach(e-> System.out.println("heeey"+e.getName()));

        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
