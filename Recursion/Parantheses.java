// Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.

public class Solution {
    public ArrayList<String> ans;
    public String[] generateParenthesis(int A) {
         ans = new ArrayList<String>();
         validParanthesis(A,new char[2*A],0,0,0);
         String[] ret = new String[ans.size()];
         for(int i = 0 ; i < ans.size(); i++)
         {
             ret[i] = ans.get(i);
         }
         return ret;
    }
    
    public void validParanthesis(int A ,char[] arr,int index,int countOpened,int countClosed)
    {
        // Bases Cases

        if(index == 2 * A)
        {
            ans.add(new String(arr));
            //System.out.print(new String(arr));
            return;
        }

        // Valid Cases
        if(countOpened < A)
        {
            arr[index] = '(';
            validParanthesis(A,arr,index+1,countOpened+1,countClosed); // Recursion
        }
        // Valid Cases
        if(countClosed < countOpened)
        {
            arr[index] = ')';
            validParanthesis(A,arr,index+1,countOpened,countClosed+1); // Recursion
        }
    }
}
