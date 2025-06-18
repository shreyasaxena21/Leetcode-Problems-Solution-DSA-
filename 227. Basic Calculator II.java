class Solution {
    public int calculate(String s) {
        //maintain a stack(it stores number)
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        char operator = '+'; // take + as a default operator
        //scan the expression from left to right
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i); //pick the char
            if(Character.isDigit(ch)){ //if its an operand
                operand = operand*10 + (ch-'0');
            // convert char into number
        
            }
            //if we get an operator    

            if(!Character.isDigit(ch) && ch!=' ' || i == s.length()-1){
                switch(operator){
                    case '+' :
                    stack.push(operand);
                    break;

                    case '-':
                    stack.push(-operand);
                    break;

                    case '*':
                    stack.push(stack.pop()*operand);
                    break;

                    case '/':
                    stack.push(stack.pop()/operand);
                    break;
                }
                operator = ch;
                operand = 0;
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }

        return result;
    }
}