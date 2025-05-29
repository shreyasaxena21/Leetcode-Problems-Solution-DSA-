class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        helper(nums,0, new ArrayList<Integer>(), bigList);
        return bigList;
        

    }

    void helper(int[]  nums,int index,  List<Integer> smallList, List<List<Integer>> bigList){

        bigList.add(new ArrayList<Integer>(smallList));
        for(int i = index; i<nums.length; i++){
            if(!smallList.contains(nums[i])){
                smallList.add(nums[i]);

                helper(nums, i, smallList, bigList);

                smallList.remove(smallList.size()-1);
            }
        }
    }
}