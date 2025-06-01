class Solution {
    //approch 1 - Brute Force
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        for(int i= 0; i<nums.length; i++){
            int count = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    count++;
                }

            }
            if(count>n/2){
                return nums[i];
            }

        }
        return -1;
    }
    //approach 2 - Hashing
    public int majorityElement2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            if(map.get(nums[i])>n/2){
                return nums[i];
            }
        }

        return -1;
    }

    //approach 3 - Boyer - Moore Voting Algo
    //TC - O(N) SC - O(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        int majElement = 0;
        for(int num : nums){
            if(count == 0){
                majElement = num;
            }
            if(num == majElement){
                count++;
            }

            else{
                count--;
            }
        }
        return majElement;
    }

}