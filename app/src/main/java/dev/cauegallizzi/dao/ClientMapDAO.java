package dev.cauegallizzi.dao;

import dev.cauegallizzi.domain.Client;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClientMapDAO implements IClientDAO {
    private Map<Long, Client> map;

    public ClientMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean Create(Client client) {
        if (map.containsKey(client.getCpf())) {
            return false;
        }

        map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void Delete(Long cpf) {
        Client registeredClient = map.get(cpf);
        map.remove(registeredClient.getCpf(), registeredClient);
    }

    @Override
    public void Update(Client client) {
        Client registeredClient = map.get(client.getCpf());
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
        return map.get(cpf);
    }

    @Override
    public Collection<Client> ReadAll() {
        return map.values();
    }
}
