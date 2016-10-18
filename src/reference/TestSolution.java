/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author macbook
 */
public class TestSolution {

    public static void main(String[] args) {
        Map<String, String> original = getValues();
        
        System.out.println("** size of original is " + original.size() + "\n");
        
        Set<String> keySet = new TreeSet<String>(original.values());
        System.out.println(keySet.toString());
        
        Map<String, Set<String>> finalList = new HashMap<>();
        
        for (String key : keySet) {
            finalList.put(key, null);
        }


    }

    public static Map<String, String> getValues() {
        
        System.out.println("(start getValues() method)");
                
        Map<String, String> map = new HashMap<>();
        
        String[] type = {"sport", "tv", "novel", "fiction", "club"};
        String[] tvValue = {"dexter", "NCIS", "CSI", "Lost", "George Show"};
        String[] novelValue = {"The train ", "The beach ", "the bus ", "Franklin Trip", "Tom Soyer's Novel"};
        String[] fictionValue = {"Startrek", "Stragate", "Dream State", "Starwars", "The Super Train"};
        String[] clubValue = {"AAA", "Costco", "Sam's Club", "Walmart", "Office Depot"};
        String[] sportValue = {"soccer", "footaball", "voleyball", "badminton", "swimming"};

        for (int i = 0; i < 5; i++) {

            map.put(tvValue[i], type[0]);
            map.put(novelValue[i],type[1]);
            map.put(fictionValue[i],type[2]);
            map.put(clubValue[i], type[3]);
            map.put(sportValue[i],type[4]);

        }

        System.out.println("** maps.keySet() is " +map.keySet() + "\n");
        System.out.println("** maps.values() is " + map.values()+ "\n");
        System.out.println("** size of map is " + map.size() + "\n");
        
        System.out.println("(end getValues() method)\n");
        
        return map;
    }
}
