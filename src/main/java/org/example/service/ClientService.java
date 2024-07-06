package org.example.service;

import org.example.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientService {

    private  final  Connection connection;

    private PreparedStatement createST;
    private PreparedStatement getById;
    private PreparedStatement selectMaxIdSt;
    private PreparedStatement getAllListClientsSt;
    private PreparedStatement updateNameSt;
    private PreparedStatement deleteByIdSt;
    public ClientService(Connection connection) throws SQLException {
        this.connection =connection;
        createST = connection.prepareStatement("INSERT INTO client(name) VALUES (?)");
        getById = connection.prepareStatement("SELECT name FROM client where id = ?");
        selectMaxIdSt = connection.prepareStatement("SELECT  max(id) AS maxId FROM  client");
        getAllListClientsSt =  connection.prepareStatement("SELECT id,name FROM client");
        updateNameSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ? ");
        deleteByIdSt = connection.prepareStatement("DELETE FROM  client WHERE id = ?");
    }

    public long create(String name) throws SQLException {
        validateName(name);
        createST.setString(1, name);
        createST.executeUpdate();
        long id ;

        try (ResultSet rs = selectMaxIdSt.executeQuery();){
            rs.next();
            id = rs.getLong("maxId");
        }

        return id;

    }

    public String getById(long id) throws SQLException {
        getById.setLong(1,id);
        try (ResultSet rs = getById.executeQuery()){
            if(!rs.next()){
                return null;
            }
            Client client = new Client();
            client.setId(id);
            client.setName(rs.getString("name"));
            return client.getName();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void setName(long id, String name) throws Exception {

        updateNameSt.setString(1,name);
        updateNameSt.setLong(2,id);
        updateNameSt.executeUpdate();
    }

    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1,id);
        deleteByIdSt.executeUpdate();


    }

    public List<Client> getAllClient() throws SQLException {

        try (ResultSet rs = getAllListClientsSt.executeQuery()){
            List<Client> clientList = new ArrayList<>();
            while (rs.next()){
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                clientList.add(client);
            }
            return clientList;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void validateName(String name) {
        if (name.length() <= 5 || name.length() >= 50) {
            throw new IllegalArgumentException("Incorrect name length: should be between 6 and 49 characters.");
        }
    }

}
