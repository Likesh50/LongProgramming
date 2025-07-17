

import java.util.*;
public class RepetitionOfLetters
{
	public static void main(String[] args) {

		String s="((x){3}(y){2}z){2}";
		Stack<String> stack=new Stack();
		
		for(char c:s.toCharArray())
		{
		    if(c=='}')
		    {
		        int num=0;
		        while(stack.peek().charAt(0)>='0' && stack.peek().charAt(0)<='9')
		        {
		            num=num*10+Integer.parseInt(stack.pop());
		        }
		        stack.pop();
		        stack.pop();
		        StringBuilder str=new StringBuilder();
		        while(!stack.peek().equals("("))
		        {
		            str.insert(0,stack.pop());
		        }
		        stack.pop();
		        
		        StringBuilder words=new StringBuilder();
		        for(int i=0;i<num;i++)
		        {
		            words.append(str.toString());
		        }
		        stack.push(words.toString());
		    }
		    else
		    {
		        stack.push(new String(c+""));
		    }
		}
		while(!stack.isEmpty())
		    System.out.println(stack.pop());
	}
	
	
}