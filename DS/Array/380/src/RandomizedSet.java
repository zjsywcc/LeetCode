import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1));

// Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2));

// Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(2));

// getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

// Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomSet.remove(1));

// 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2));

// Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());
    }

    HashMap<Integer, Integer> map;
    List<Integer> indexList;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        indexList = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            map.put(val, indexList.size());
            indexList.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // The trick part is swap the last one of array with the one to be deleted
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        } else {
            int index = map.get(val);
            int len = indexList.size();
            int lastValue = indexList.get(len - 1);
            indexList.set(index, lastValue);
            map.put(lastValue, index);
            indexList.remove(len - 1);
            map.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(indexList.size());
        return indexList.get(randomIndex);
    }


}
