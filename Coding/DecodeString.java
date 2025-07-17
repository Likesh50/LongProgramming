

//https://leetcode.com/problems/decode-string/

import java.util.*;

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> num=new Stack<>();
        Stack<String> ch=new Stack<>();
        int idx=0;
        int len=s.length();
        
        while(idx<len)
        {
            char c=s.charAt(idx);
            if(Character.isDigit(c))
            {
                String number="";
                while(Character.isDigit(c))
                {
                    number+=c;
                    c=s.charAt(++idx);
                }
                num.push(Integer.parseInt(number));
            }
            else
            {
                if(c==']')
                {
                    StringBuilder str=new StringBuilder();
                    while(!ch.peek().equals("["))
                    {
                        str.insert(0,ch.pop());
                    }
                    ch.pop();
                    String word=str.toString();
                    int n=num.pop();
                    StringBuilder iteration = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        iteration.append(word);
                    }
                    ch.push(iteration.toString());

                }
                else
                {
                    ch.push(c+"");
                }
                idx++;
            }
        }
        StringBuilder res=new StringBuilder();
        while(!ch.isEmpty())
        {
            res.insert(0,ch.pop());
        }
        return res.toString();
    }
}