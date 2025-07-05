class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer,Integer> mapElement : map.entrySet()){
            if(mapElement.getValue().equals(mapElement.getKey())){
                int element = mapElement.getKey();  
                max = Math.max(max, element);
                
            }
        }

        return max;   

        
    }
}