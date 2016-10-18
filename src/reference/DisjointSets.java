package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
This Java program is to Implement Disjoint set data structure. 
In computing, a disjoint-set data structure is a data structure 
that keeps track of a set of elements partitioned into a number of disjoint 
(nonoverlapping) subsets. 

A union-find algorithm is an algorithm that performs two useful operations 
on such a data structure:
    _Find:  Determine which subset a particular element is in. 
            This can be used for determining if two elements are 
            in the same subset.
    _Union: Join two subsets into a single subset.
 */

/*
this DisjointSets is not suitable solution for 445 project.
DisjoinSet is used for path matching.

*/
public class DisjointSets {

    private List<Map<Integer, Set<Integer>>> mDisjointSet;

    public DisjointSets() {
        mDisjointSet = new ArrayList<Map<Integer, Set<Integer>>>();
    }

    public void create_set_then_add_to_mDisjointSet(int element) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(element);
        map.put(element, set);
        mDisjointSet.add(map);
    }

    /*
    purpose : join two subsets into a single set
    
    How wo join two subsets into a single set?
    
    
     */
    public void union(int first, int second) {
        //what does match_value_and_return_key_otherwise_return_negone(int) do? 
        int first_rep = match_value_and_return_key_otherwise_return_negone(first);
        int second_rep = match_value_and_return_key_otherwise_return_negone(second);

        Set<Integer> first_set = null;
        Set<Integer> second_set = null;

        //put second_set into first_set
        for (Map<Integer, Set<Integer>> map : mDisjointSet) {
            if (map.containsKey(first_rep)) {
                first_set = map.get(first_rep);
            } else if (map.containsKey(second_rep)) {
                second_set = map.get(second_rep);
            }
        }

        if (first_set != null && second_set != null) {
            first_set.addAll(second_set);
        }

        //remove second_set from mDisjointSet
        for (int index = 0; index < mDisjointSet.size(); index++) {
            Map<Integer, Set<Integer>> map = mDisjointSet.get(index);
            if (map.containsKey(first_rep)) {
                map.put(first_rep, first_set);
            } else if (map.containsKey(second_rep)) {
                map.remove(second_rep);
                mDisjointSet.remove(index);
            }
        }

    }//end union method

    public int match_value_and_return_key_otherwise_return_negone(int element) {
        for (Map<Integer, Set<Integer>> map : mDisjointSet) {

            Set<Integer> keySet = map.keySet();

            for (Integer key : keySet) {
                Set<Integer> set = map.get(key);

                if (set.contains(element)) {
                    return key;
                }
            }
        }
        return -1;
    }

    public int getNumberofDisjointSets() {
        return mDisjointSet.size();
    }

    public static void main(String... arg) {
        DisjointSets disjointSet = new DisjointSets();

        for (int i = 1; i <= 5; i++) {
            disjointSet.create_set_then_add_to_mDisjointSet(i);
        }

        System.out.println("ELEMENT : REPRESENTATIVE KEY");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "\t:\t" + disjointSet.match_value_and_return_key_otherwise_return_negone(i));
        }

        disjointSet.union(1, 5);
        disjointSet.union(5, 3);

        System.out.println("\nThe Representative keys after performing the union operation\n");
        System.out.println("Union of (1 and 5)  and (5 and 3) ");

        System.out.println("ELEMENT : REPRESENTATIVE KEY");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "\t:\t" + disjointSet.match_value_and_return_key_otherwise_return_negone(i));
        }

        System.out.println("\nThe number of disjoint set : " + disjointSet.getNumberofDisjointSets());
    }
}
