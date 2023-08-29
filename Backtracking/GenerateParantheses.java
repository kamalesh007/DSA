// Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
public class Solution {
    public ArrayList<String> ans;
    public int globalA;
    public ArrayList<String> generateParenthesis(int A) {
        ans=new ArrayList<String>();
        globalA=A;
        solveGenPara(new ArrayList<String>(),0,0);        
        return ans;
    }
    public void solveGenPara(ArrayList<String> cur,int currOpened,int currClosed)
    {
        if(currOpened+currClosed == 2*globalA)
        {
            ArrayList<String> clonedList=(ArrayList<String>)cur.clone();
            String ans1="";
            for(String c:clonedList)
            {
                ans1+=c;
            }
            ans.add(ans1);
            return;
        }
        
        if(currOpened<globalA)
        {
            cur.add("(");
            solveGenPara(cur,currOpened+1,currClosed);
            cur.remove(cur.size()-1);
        }
        if(currClosed<currOpened)
        {
            cur.add(")");
            solveGenPara(cur,currOpened,currClosed+1);
            cur.remove(cur.size()-1);
        }
    }
}
