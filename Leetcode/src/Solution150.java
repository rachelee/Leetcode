import java.util.*;
public class Solution150 {
	public int evalRPN(String[] tokens) {
        int val = 0;
        Stack<String> stack = new Stack<>();
        String operators = "+-*/";
        for(String s: tokens)
        {
            if(!operators.contains(s))
                stack.push(s);
            else
            {
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                switch(s)
                {
                    case "+":
                        val = num1 + num2;
                        break;
                    case "-":
                        val = num2 - num1;
                        break;

                    case "*":
                        val = num1 * num2;
                        break;

                    case "/":
                        val = num2/num1;
                        break;

                        
                }
                stack.push(String.valueOf(val));
            }
        }
        int res = Integer.valueOf(stack.pop());
        return res;
		
 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4","-2","/","2","-3","-","-"};
		Solution150 test = new Solution150();
		System.out.println(test.evalRPN(tokens));
	}

}
