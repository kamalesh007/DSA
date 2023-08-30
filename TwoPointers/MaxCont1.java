// Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.

// For this problem, return the indices of maximum continuous series of 1s in order.

// If there are multiple possible solutions, return the sequence which has the minimum start index.

public class Solution {
    public int[] maxone(int[] A, int B) {
    int[] ans = new int[2];
    int ones = 0;
    int i = 0;
    int j = -1;
    int currentB = B;
    int count = 0;
    int maxLen = -1;
    while(j+1 < A.length)
    {            
        //System.out.print(j+". ");
        if(A[j+1] == 1)
        {
            count ++;
            j++;
        }
        else if(A[j+1] == 0 && currentB >0)
        {
            count ++;
            j++;
            currentB --;
        }
        else if(A[j+1] == 0 && currentB <= 0)
        {
            if(A[i] == 1)
            {
                count --;
                i++;
            }
            else
            {
                count --;
                i++;
                currentB++;
            }
        }

        if(j-i+1 > maxLen)
        {
            maxLen = j-i+1;
            ans[0] = i;
            ans[1] = j;
        }

        
        
    }

    int[] res = new int[ans[1]-ans[0]+1];
    int k = 0;

    for(int x = ans[0] ; x<= ans[1]; x++)
    {
        res[k++]= x;
    }

    return res;
    
    }
}
