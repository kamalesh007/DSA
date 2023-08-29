// Given a digit string A, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

// NOTE: Make sure the returned strings are lexicographically sorted.

public class Solution {
    public String[] arr;
    public ArrayList<String> ans;
    public ArrayList<String> letterCombinations(String A) {
        arr= new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans=new ArrayList<String>();
        solve(arr,A,new ArrayList<Character>(),0);
        return ans;
    }

    public void solve(String[] arr,String A,ArrayList<Character> current,int index)
    {        
        if(index == A.length())
        {
            String temp="";
            for(Character c:current)
            {
               temp += c; 
            }
            ans.add(temp);
            return;
        }
        char getIndexStr=A.charAt(index);
        String choices=  arr[getIndexStr - '0' ];
        int lengthOfChoices = choices.length();
        for(int i=0;i<lengthOfChoices;i++)
        {
            current.add(choices.charAt(i));
            solve(arr,A,current,index+1);
            current.remove(current.size()-1);
        }
    }
}
