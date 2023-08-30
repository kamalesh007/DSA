// Given an one-dimensional integer array A of size N and an integer B.

// Count all distinct pairs with difference equal to B.

// Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.

public class Solution {
    public int solve(int[] A, int B) {

    Arrays.sort(A);    
    HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    int count = 0;
    for(int i = 0 ; i < A.length ; i++)
    {
        int fre = hm.getOrDefault(A[i],0);
        hm.put(A[i],fre+1);
    }

    int i = 0; 
    int j = 1;

    while(j < A.length )
    {
        if(i >= j)
        {
            j++;
            continue;
        }

        int diff = A[j] - A[i];

        if(diff > B)
        {
            i++;            
        }
        else if(diff< B)
        {
            j++;
        }
        else
        {
            //System.out.print(A)
            count ++; // Since distinct pair consider only once.
            j = j + hm.get(A[j]);
        }        
    }
    //System.out.print(i+"\t"+j);

    return count;
   
    }
}
