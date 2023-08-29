// Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.

// Return all possible results.

// You can return the results in any order.
public class Solution {
    
    public ArrayList<String> ans;

    public ArrayList<String> allSubsequences;

    public int N;

    public String characterAvailable;

    public int optimalSize;

    public ArrayList<String> solve(String A) {
        ans=new ArrayList<String>();
        allSubsequences= new ArrayList<String>();
        N=A.length();
        characterAvailable ="";
        optimalSize=Integer.MIN_VALUE;        
        gen(0,new ArrayList<Character>() ,A);
        for(String x : allSubsequences)
        {
            boolean val=checkvalidity(x);            
            if(val && x.length()==optimalSize)
            {
                if(!ans.contains(x))
                {
                    ans.add(x);
                }
                
            }
            else if(val && x.length() > optimalSize)
            {
                ans.clear();
                if(!ans.contains(x))
                {
                    ans.add(x);
                }
                optimalSize = x.length();
            }
                                 
        }

        return ans;
    }

    public void gen(int index,ArrayList<Character> curr,String ip)
    {
        if(index == N)
        {
            String temp = "";
            ArrayList<Character> curClone=(ArrayList<Character>)curr.clone();
            for(Character c: curClone)
            {
                temp += c;
            }            
            allSubsequences.add(temp);
            return ;
        }
        else
        {
            curr.add(ip.charAt(index));
            gen(index+1,curr,ip);
            curr.remove(curr.size()-1);
            gen(index+1,curr,ip);                       
            //curr.remove(curr.size()-1);
        }
        
    }

    public boolean checkvalidity(String A)
    {
        int noOpen=0,noClose=0;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='(')
            {
                noOpen++;
            }
            else if(A.charAt(i)==')')
            {
                if(noOpen > 0)
                {
                    noOpen --;
                }
                else
                {
                    return false;
                }
            }
        }
        return noOpen == 0;
    }
}
