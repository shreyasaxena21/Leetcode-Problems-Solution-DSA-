class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        // scan the roman Number from left to right

        int i = 0;
        int sum = 0;
        while(i<s.length()){
            char singleChar = s.charAt(i); // Get the single char from the string
            String currentSymbol = String.valueOf(singleChar); // convert char into string

            int currentValue = map.get(currentSymbol);
            int nextValue = 0;

            if(i+1<s.length()){
                char nextChar = s.charAt(i+1);
                String nextSymbol = String.valueOf(nextChar);
                nextValue = map.get(nextSymbol);
            } 

            if(currentValue<nextValue){
                sum = sum + (nextValue - currentValue);
                i = i+2;
            }

            else{
                sum = sum + currentValue;
                i = i+1;
            }
        }

        return sum;


    }
}