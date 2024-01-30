package org.iesvdm.ejemplo.controller;

import org.iesvdm.ejemplo.model.Client;
import org.iesvdm.ejemplo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {

    // Service inyection
    @Autowired
    ClientService clientService;

    // Mapping

    // List all clients
    @GetMapping("/clients")
    public String list(Model model){

        List<Client> clientList = this.clientService.listAll();
        model.addAttribute("clientList", clientList);

        return "clients";
    }

    // Details of a specified client
    @GetMapping("/clients/{id}")
    public String details(Model model, @PathVariable Integer id){

        Client client = this.clientService.one(id);
        model.addAttribute("client", client);

        return "client-details";
    }

    @GetMapping("/clients/create")
    public String create(Model model){

        Client client = new Client();
        model.addAttribute("client", client);

        return "create-client";
    }

    @PostMapping("/clients/create")
    public String submitCreate(@ModelAttribute("client") Client client){

        this.clientService.create(client);

        return "redirect:/clients";
    }

    @GetMapping("/clients/edit/{id}")
    public String edit(Model model, @PathVariable Integer id){

        Client client = new Client();
        model.addAttribute("client", client);

        return "client-edit";
    }

    @PostMapping("/clients/edit/{id}")
    public String submitEdit(@ModelAttribute("client") Client client){

        this.clientService.replace(client);

        return "redirect:/clients";
    }

    @PostMapping("/clients/delete/{id}")
    public String submitDelete(@PathVariable Integer id){

        this.clientService.delete(id);

        return "redirect:/clients";
    }
}
