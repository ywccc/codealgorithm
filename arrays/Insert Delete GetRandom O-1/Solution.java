class RandomizedSet {
    ArrayList<Integer> set;
    HashMap<Integer,Integer> help;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new ArrayList<Integer>();
        help = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(help.containsKey(val)) return false;
        help.put(val,set.size());
        set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!help.containsKey(val)) return false;
        int key = help.get(val);
        if(key < set.size())
        {
            int tmp = set.get(set.size()-1);
            set.set(key,tmp);
            help.put(tmp,key);
        }
        set.remove(set.size()-1);
        help.remove(val);
        return true;
        
    }
    
    
    /** Get a random element from the set. */
    public int getRandom() {
        return set.get(rand.nextInt(set.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
