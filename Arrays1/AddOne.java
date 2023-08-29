// Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

// The digits are stored such that the most significant digit is at the head of the list.

// NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

// Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
// A: For the purpose of this question, YES
// Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
// A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
public class Solution {
    public int[] plusOne(int[] A) {

        int carry = 1 ;
        String ans = "";
        for(int i = A.length - 1; i>=0 ;i--)
        {
            int sum = A[i]+carry;
            int digit = sum % 10;
            carry = sum / 10;            
            ans = digit + ans;
        }

        if(carry!=0)
        {
            ans = carry + ans;
        }        
               

        for(int i = 0; i< ans.length()-1 ;i++)
        {
            if(ans.charAt(i) == '0' && ans.charAt(i+1) == '0')
            {
                continue;
            }
            else
            {
                int[] plusOneArray = new int[0];
                int startOffset = 0;
                if(ans.charAt(i)!='0')
                {
                    startOffset = i;
                    plusOneArray = new int[ans.length() - 1 - i + 1];
                    
                }
                else if(ans.charAt(i+1) != '0')
                {
                   startOffset = i+1;
                    plusOneArray = new int[ans.length() - 1 -startOffset + 1];                    
                    
                }

                for(int j = 0 ; j< plusOneArray.length;j++)
                {
                    plusOneArray[j] = ans.charAt(startOffset+j) - '0';
                }
                return plusOneArray;
            }
        }        
       // int[] re = ;
        return new int[]{ans.charAt(0)-'0'};      

    }
}
