class Solution {
    private boolean compareOpeningAndClosing(char openingBracket, char closingBracket){
        return ((openingBracket == '(' && closingBracket ==')') || (openingBracket == '{' && closingBracket =='}') || (openingBracket == '[' && closingBracket ==']'));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // s conatins all the brackets
        // pick the bracket ne by one
        for(char singleBrackte : s.toCharArray()){
            if(singleBrackte == '(' || singleBrackte == '{' || singleBrackte == '['){
                stack.push(singleBrackte);
            }

            else if(!stack.isEmpty() && compareOpeningAndClosing(stack.peek(), singleBrackte)){
                stack.pop();
            }
            else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}