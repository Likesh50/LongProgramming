

//https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        
        int n=tokens.length;
        Stack<Integer> stack=new Stack<>();

        for(String num:tokens)
        {
            if(num.equals("+"))
            {
                int val=stack.pop()+stack.pop();
                stack.push(val);
            }
            else if(num.equals("-"))
            {
                int n1=stack.pop();
                n1=stack.pop()-n1;
                stack.push(n1);
            }
            else if(num.equals("*"))
            {
                int n1=stack.pop();
                n1=stack.pop()*n1;
                stack.push(n1);
            }
            else if(num.equals("/"))
            {
                int n1=stack.pop();
                n1=stack.pop()/n1;
                stack.push(n1);
            }
            else 
            {
                stack.push(Integer.parseInt(num));
            }
        }

        return stack.pop();
    }
}