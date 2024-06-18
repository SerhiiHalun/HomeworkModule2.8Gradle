package org.example.return_entity_query;

import org.example.Database;
import org.example.DatabaseQueryService;
import org.example.service_execute_classes.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        List<LongestProject> listLP = DatabaseQueryService.findLongestProject();
        System.out.println(listLP.toString());
        
        List<MaxProjectClients> listMPC = DatabaseQueryService.findMaxProjectsClient();
        System.out.println(listMPC.toString());

        List<MaxSalaryWorker> listMSW = DatabaseQueryService.findMaxSalaryWorker();
        System.out.println(listMSW.toString());

        List<YoungestEldestWorker> listYEW = DatabaseQueryService.findYoungestEldestWorker();
        System.out.println(listYEW.toString());

        List<ProjectPrices> listPP = DatabaseQueryService.findProjectPrices();
        System.out.println(listPP.toString());

    }
}