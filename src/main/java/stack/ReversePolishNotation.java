class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(isNumber(s)){
                stack.push(Integer.valueOf(s));
            }
            else{
                int opp2 = stack.pop();
                int opp1 = stack.pop();
                stack.push(operate(opp1, opp2, s));
            }
        }
        return stack.pop();
    }

    private Boolean isNumber(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }
        else{
            return true;
        }
    }

    private int operate(int opp1, int opp2, String operation){
        if(operation.equals("+")){
            return opp1 + opp2;
        }
        else if(operation.equals("-")){
            return opp1 - opp2;
        }
        else if(operation.equals("*")){
            return opp1 * opp2;
        }
        else{
            return opp1 / opp2;
        }
    }
}