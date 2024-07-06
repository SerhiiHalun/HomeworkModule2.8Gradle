package org.example.service;

import org.example.entity.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {
    private Connection connection;
    private ClientService clientService;

    @BeforeEach
    public  void beforeEach() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:company;DB_CLOSE_DELAY=-1");
        clientService = new ClientService(connection);
    }
    @AfterEach
    public  void afterEach() throws SQLException {
        connection.close();
    }

    //Can create valid client with all filled fields
    @Test
    public void testThatHumanCreateCorrectly() throws SQLException {
        Client client = new Client();
        client.setName("TestName");
        client.setId(1);
        final long id = clientService.create(client);

        Client saved = clientService.getById(id);

        //Assert
        Assertions.assertEquals(id,saved.getId());
        Assertions.assertEquals(client.getName(),saved.getName());

    }
}