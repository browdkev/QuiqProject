/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncomparision;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Set;

/**
 *
 * @author Kevin
 */
public class CompareJSON {
    private JsonElement master;
    private JsonElement child;
    
    CompareJSON(JsonElement master, JsonElement child){
        this.master = master;
        this.child = child;
    }
    
    public double Compare(){
        if(master.equals(child))
        {
            return 1;
        }
        else if(master.isJsonObject())
        {
            JsonObject masterobj = master.getAsJsonObject();
            Set<String> keys = masterobj.keySet();
            System.out.println(keys);
            for(String key : keys){
                System.out.println(masterobj.get(key));
            }
        }
        double similarity = 0;
        
        return similarity;
    }

    public void setMaster(JsonElement master) {
        this.master = master;
    }

    public void setChild(JsonElement child) {
        this.child = child;
    }
      
}
