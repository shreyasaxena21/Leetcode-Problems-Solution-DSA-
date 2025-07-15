class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        // Store list1 elements with their indices
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;

        // Traverse list2 and check for common strings
        for (int j = 0; j < list2.length; j++) {
            String str = list2[j];
            if (map.containsKey(str)) {
                int sum = j + map.get(str);
                if (sum < minSum) {
                    result.clear();  // found a better minimum
                    result.add(str);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(str);  // same minimum, add to result
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
