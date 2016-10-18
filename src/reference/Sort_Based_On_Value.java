package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
Run Time : N^3

This solution is not suitable for the 
*/

public class Sort_Based_On_Value {
  public static void main(String[] a) {
    Map<String, String> yourMap = new HashMap<String, String>();
    yourMap.put("1", "one");
    yourMap.put("2", "two");
    yourMap.put("3", "three");

    Map<String, Object> map = new LinkedHashMap<String, Object>();

    List<String> keyList = new ArrayList<String>(yourMap.keySet());
    List<String> valueList = new ArrayList<String>(yourMap.values());
    Set<String> sortedSet = new TreeSet<String>(valueList);
    
    Object[] sortedArray = sortedSet.toArray();
    int size = sortedArray.length;

    for (int i = 0; i < size; i++) {
      int index = valueList.indexOf(sortedArray[i]);
      map.put(keyList.get(index), sortedArray[i]);
    }

    Set ref = map.keySet();
    Iterator it = ref.iterator();

    while (it.hasNext()) {
      String i = (String) it.next();
      System.out.println(i);
    }
  }
}

/*
run:
1
3
2
BUILD SUCCESSFUL (total time: 0 seconds)
*/