class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> smallList=new ArrayList<>();
        List<List<Integer>> bigList = new ArrayList<>();
        helper(1, n, k, smallList, bigList);
        return bigList;
    }

    void helper(int start, int n, int k, List<Integer> smallList, List<List<Integer>> bigList){

        //base case
        if(k==smallList.size()){
            bigList.add(new ArrayList<>(smallList));
        }

        //loop
        for(int i = start; i <= n; i++){
            // if(!smallList.contains(i)){
                smallList.add(i);
                helper(i+1, n, k, smallList, bigList);

                //backtracking
                smallList.remove(smallList.size()-1);
            // }

        }
    }
}