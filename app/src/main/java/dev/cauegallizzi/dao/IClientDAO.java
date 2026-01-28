package dev.cauegallizzi.dao;

import dev.cauegallizzi.domain.Client;

import java.util.Collection;

public interface IClientDAO {
    public Boolean Create (Client client);
    public void Delete(Long cpf);
    public void Update(Client client);
    public Client Read(Long cpf);
    public Collection<Client> ReadAll();
}
