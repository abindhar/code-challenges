import java.util.Stack;

public class evalReversePolishNotation {
    static final Set<String> operators = new HashSet<>();
    static{
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }
    public int evalRPN(String[] tokens) {
        // Naive: Use the original token array itself O(n^2) time O(1) space
        // Better: Use additional stack O(n) time and O(n) space
        // Negative numbers prove to be a problem when dividing eg -13/2 = -6.5
        // Now truncate it towards zero => -6
        Stack<Integer> stack = new Stack();

        for (String s : tokens){
            if (! operators.contains(s)){
                // If current string is not an operator
                stack.push(Integer.parseInt(s));
                continue;
            }
            int x = stack.pop();
            int y = stack.pop();
            switch (s){
                case "+":
                    stack.push(y+x);
                    break;
                case "-":
                    stack.push(y-x);
                    break;
                case "*":
                    stack.push(y*x);
                    break;
                case "/":
                    stack.push((int) ((float)y / (float)x));
                    break;
            }

        }
        return stack.pop();
    }
}
