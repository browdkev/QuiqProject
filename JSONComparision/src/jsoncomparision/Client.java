/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncomparision;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 *
 * @author Kevin
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        importJson();
        
    }
    private static void importJson(){
        final String JSON_PATH = "BreweriesMaster.json";
        final String JSON_PATH1 = "BreweriesSample2.json";
        
        try{
           
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
            BufferedReader br1 = new BufferedReader(new FileReader(JSON_PATH1));
            
            JsonElement master = gson.fromJson(br, JsonElement.class);
            JsonElement child = gson.fromJson(br1, JsonElement.class);
            CompareJSON compare = new CompareJSON(master, child);
            System.out.println(compare.Compare());
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }  
    }
}
