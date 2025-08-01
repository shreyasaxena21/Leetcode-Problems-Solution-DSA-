
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(char singleChar : s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek()- singleChar) == 32){
                stack.pop();
            }

            else{
                stack.push(singleChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char singleChar : stack){
            sb.append(singleChar);
        }    
        
        return sb.toString();
    }
}