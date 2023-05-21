package org.java.dev;
import org.java.dev.configuration.FlywayConfiguration;
import org.java.dev.configuration.LoggingConfiguration;
import org.java.dev.crud.entity.Client;
import org.java.dev.crud.service.ClientService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        new LoggingConfiguration();
        FlywayConfiguration flywayConfiguration = new FlywayConfiguration().setup();
        flywayConfiguration.migrate();

        ClientService clientService = new ClientService();

        long newClientID = clientService.create("Tommy");
        System.out.println("newClientID = " + newClientID);

        String clientName = clientService.getById(newClientID);
        System.out.println("clientName = " + clientName + "  => ID = " + newClientID);

        clientService.setName(newClientID, "Boris");
        clientName = clientService.getById(newClientID);

        List<Client> clientList = clientService.listAll();
        System.out.println("clientList = " + clientList);

        clientService.deleteById(newClientID);

        clientList = clientService.listAll();
        System.out.println("clientList = " + clientList);
    }
}