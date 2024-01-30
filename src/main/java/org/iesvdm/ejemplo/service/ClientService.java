package org.iesvdm.ejemplo.service;

import org.iesvdm.ejemplo.DAO.ClientDAO;
import org.iesvdm.ejemplo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ServiceBase<Client>{

    // DAO inyection
    @Autowired
    private ClientDAO<Client> clientDAO;

    // Services
    @Override
    public List<Client> listAll() {

        return this.clientDAO.getAll();
    }

    @Override
    public Client one(int id) {

        return this.clientDAO.find(id).get();
    }

    @Override
    public void create(Client client) {

        this.clientDAO.create(client);
    }

    @Override
    public void replace(Client client) {

        this.clientDAO.update(client);
    }

    @Override
    public void delete(int id) {

        this.clientDAO.delete(id);
    }
}
