class Solution {
    public String removeDuplicates(String s) {

        StringBuilder stack = new StringBuilder();
        char [] letters = s.toCharArray();

        for(char letter : letters){
            if(stack.length()>0 && stack.charAt(stack.length()-1) == letter){
                stack.deleteCharAt(stack.length()-1);
            }

            else{
                stack.append(letter);
            }
        }

        return stack.toString();

    }
}



        // Stack<Character> stack = new Stack<>(); // stack to store the elements of the string

        // for(char singleChar : s.toCharArray()){
        //     if(stack.size()>0 && stack.peek()==singleChar){
        //         stack.pop();
        //     }

        //     else{
        //         stack.push(singleChar);
        //     }

        // }

        // String result = "";
        // while(!stack.isEmpty()){
        //     result+=stack.pop();
        // }

        // return new StringBuilder(result).reverse().toString();
//     }
// }