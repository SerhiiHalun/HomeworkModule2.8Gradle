package org.example.query_entity;

import org.example.Database;
import org.example.service.ClientService;
import org.example.entity.*;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        try {
            ClientService clientService = new ClientService(database.getConnection());
            long idClient = clientService.create("Ser");
            System.out.println(idClient);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

//        List<LongestProject> listLP = DatabaseQueryService.findLongestProject();
//        System.out.println(listLP.toString());
//
//        List<MaxProjectClients> listMPC = DatabaseQueryService.findMaxProjectsClient();
//        System.out.println(listMPC.toString());
//
//        List<MaxSalaryWorker> listMSW = DatabaseQueryService.findMaxSalaryWorker();
//        System.out.println(listMSW.toString());
//
//        List<YoungestEldestWorker> listYEW = DatabaseQueryService.findYoungestEldestWorker();
//        System.out.println(listYEW.toString());
//
//        List<ProjectPrices> listPP = DatabaseQueryService.findProjectPrices();
//        System.out.println(listPP.toString());