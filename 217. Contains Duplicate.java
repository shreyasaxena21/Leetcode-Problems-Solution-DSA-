class Solution {
    public boolean containsDuplicate1(int[] nums) {
        //Approach 1
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }
            else{
                map.put(i, map.get(i)+1);
            }
        }

        for(int i : nums){
            if(map.get(i)>1){
                return true;
            }
        }

        return false;
    }

    //Approach 2
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }

            set.add(i);
        }
        return false;
    
    
    }
}