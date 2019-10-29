/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncomparision;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Set;

/**
 * Class takes two JSON elements and compares their similarity and outputs
 * results to console
 * @author Kevin
 */
public class CompareJSON {

    //global declaration of JSON elements
    private JsonElement master;
    private JsonElement child;

    //global variables to keep count during recursive iteration in compare
    private int iterations;
    private int differences;

    /**
     * Constructor takes in two JSON elements and assigns them to global
     * variables
     * @param master
     * @param child
     */
    CompareJSON(JsonElement master, JsonElement child) {
        this.master = master;
        this.child = child;
    }

    /**
     * calls recursive method and outputs results to console runs recursion
     * twice to compare master to child and child to master
     */
    public void Compare() {
        //compare both directions (master>child, child>master)
        CompareRecursive(master, child);
        CompareRecursive(child, master);
        //calculate similarity
        double similarity = ((double) iterations - (double) differences) / (double) iterations;
        //reset global variables to prepare for another call
        iterations = 0;
        differences = 0;
        System.out.println("The files have a similarity of " + similarity);
    }

    /**
     * Recursive method compares differences between MASTER and CHILD this is a
     * one directional comparison from MASTER to CHILD Iterates recursively
     * until a primitive data type is found then compares for similarity and add
     * to running total
     * @param master
     * @param child
     */
    private void CompareRecursive(JsonElement master, JsonElement child) {
        //determining type of JSON element
        //calls recursivly if type is not primative
        if (master.isJsonObject()) {
            if (child == null) {
                iterations++;
                differences++;
            } //if masters is object call recursivily on each of objects elements
            else {
                JsonObject masterobj = master.getAsJsonObject();
                JsonObject childobj = child.getAsJsonObject();
                Set<String> masterkeys = masterobj.keySet();
                for (String key : masterkeys) {
                    CompareRecursive(masterobj.get(key), childobj.get(key));
                }
            }
        } else if (master.isJsonArray()) {
            if (child == null) {
                iterations++;
                differences++;
            } //if master is array, then compare 
            else {
                JsonArray masterarray = master.getAsJsonArray();
                JsonArray childarray = child.getAsJsonArray();
                int runs;
                //if more elements in master array than child
                if (childarray.size() < masterarray.size()) {
                    runs = childarray.size();
                    //add iterations and differences equal to number of extra elements in master array
                    iterations += masterarray.size() - childarray.size();
                    differences += masterarray.size() - childarray.size();
                } else {
                    runs = masterarray.size();
                }
                for (int i = 0; i < runs; i++) {
                    CompareRecursive(masterarray.get(i), childarray.get(i));
                }
            }
        } else if (master.isJsonPrimitive()) {
            if (master.equals(child)) {
                iterations++;
            } else {
                iterations++;
                differences++;
            }
        }
    }

    /**
     * Setter to change master JSON element
     * @param master 
     */
    public void setMaster(JsonElement master) {
        this.master = master;
    }
    /**
     * Setter to change child JSON element
     * @param child 
     */
    public void setChild(JsonElement child) {
        this.child = child;
    }

}
