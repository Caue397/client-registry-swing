package dev.cauegallizzi.dao;

import dev.cauegallizzi.domain.Client;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClientSetDAO implements IClientDAO {
    private Set<Client> set;

    public ClientSetDAO() {
        set = new HashSet<>();
    }

    @Override
    public Boolean Create(Client client) {
        for (Client c : set) {
            if (c.getCpf().equals(client.getCpf())) {
                return false;
            }
        }

        set.add(client);
        return true;
    }

    @Override
    public void Delete(Long cpf) {
        Client registeredClient = findByCpf(cpf);
        if (registeredClient != null) {
            set.remove(registeredClient);
        }
    }

    @Override
    public void Update(Client client) {
        Client registeredClient = findByCpf(client.getCpf());
        if (registeredClient == null) { return; }
        registeredClient.setName(client.getName());
        registeredClient.setCpf(client.getCpf());
        registeredClient.setEnd(client.getEnd());
        registeredClient.setState(client.getState());
        registeredClient.setCity(client.getCity());
        registeredClient.setTel(client.getTel());
        registeredClient.setNumber(client.getNumber());
    }

    @Override
    public Client Read(Long cpf) {
        return findByCpf(cpf);
    }

    @Override
    public Collection<Client> ReadAll() {
        return set;
    }

    private Client findByCpf(Long cpf) {
        for (Client c : set) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }
}
