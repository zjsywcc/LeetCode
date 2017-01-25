import java.util.*;

public class RandomizedCollection {

    public static void main(String[] args) {
        // Init an empty collection.
        RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
        System.out.println(collection.insert(1));

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
        System.out.println(collection.insert(1));

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
        System.out.println(collection.insert(2));

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
        System.out.println(collection.getRandom());

// Removes 1 from the collection, returns true. Collection now contains [1,2].
        System.out.println(collection.remove(1));

// getRandom should return 1 and 2 both equally likely.
        System.out.println(collection.getRandom());
    }

    HashMap<Integer, List<Integer>> map;

    List<Integer> indexList;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, List<Integer>>();
        indexList = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            map.get(val).add(indexList.size());
            indexList.add(val);
            return false;
        } else {
            List<Integer> list = new ArrayList<Integer>(){{
                add(indexList.size());
            }};
            map.put(val, list);
            indexList.add(val);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        } else {
            List<Integer> bucketList = map.get(val);
            int size = bucketList.size();
            int index = bucketList.get(size - 1);
            int lastValue = indexList.get(indexList.size() - 1);
            indexList.set(index, lastValue);
            indexList.remove(indexList.size() - 1);
            List<Integer> lastValueBucketList = map.get(lastValue);
            int lastSize = lastValueBucketList.size();
            map.get(lastValue).set(lastSize - 1, index);
            Collections.sort(map.get(lastValue));
            if(size == 1) {
                map.remove(val);
            } else {
                map.get(val).remove(size - 1);
            }
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        int randIndex = rand.nextInt(indexList.size());
        return indexList.get(randIndex);
    }
}
