class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> set = new ArrayList<>();
        set.add(nums[0]);
        int count=0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                set.add(nums[i]);
            }
        }

    
        for(int i = 1; i<set.size()-1; i++){

            int prev = set.get(i-1);
            int current  = set.get(i);
            int next = set.get(i+1);
            if((current>next && current>prev) || (current<next && current<prev)){
                count++;
            }
        }

        return count;
    }
}