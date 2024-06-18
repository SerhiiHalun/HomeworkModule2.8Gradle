package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileSupportSQL {
    public static String fileReader(String fileName){
        try (BufferedReader sqlInit = new BufferedReader(new FileReader(fileName))) {

            StringBuilder sqlRequest = new StringBuilder();
            String line;
            while ((line = sqlInit.readLine()) != null) {
                sqlRequest.append(line+" ");
            }
            return sqlRequest.toString();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
