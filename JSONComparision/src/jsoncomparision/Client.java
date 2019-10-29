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
import java.util.Scanner;

/** 
 * Client class gets file paths from user, reads in JSONs and calls compare
 * @author Kevin
 */
public class Client {

    /**
     * Client class gets file paths from user, reads in JSONs and calls compare
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        importJson();

    }
    /**
     * Method gets file locations from user, reads in JSONs and compares them using
     * Compare class
     */
    private static void importJson() {
        //get json file locations 
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Enter path to first file");
        final String JSON_Master = scanner.nextLine();  
        
        System.out.println("Enter path to second file");
        final String JSON_Child = scanner.nextLine();
        //read JSON files in using GSON
        try {

            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(JSON_Master));
            BufferedReader br1 = new BufferedReader(new FileReader(JSON_Child));

            JsonElement master = gson.fromJson(br, JsonElement.class);
            JsonElement child = gson.fromJson(br1, JsonElement.class);
            CompareJSON compare = new CompareJSON(master, child);
            //call comparison on JSON files
            compare.Compare();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
