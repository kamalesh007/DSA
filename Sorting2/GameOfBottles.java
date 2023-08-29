// Given an array of integers, A of length N denotes N cylindrical empty bottles. The radius of the ith bottle is A[i].
// You can put the ith bottle into the jth bottle if the following conditions are met:

// The ith bottle is not put into another bottle.
// The jth bottle doesn't contain any other bottle.
// The radius of bottle i is smaller than bottle j (A[i] < A[j]).
// You can put bottles into each other any number of times. You want to MINIMIZE the number of visible bottles. A bottle is visible if it is not put into any other bottle.

// Find and return the minimum number of visible bottles.

public class Solution {
    public int solve(int[] A) {
        int count = A.length;
        Arrays.sort(A);
               
        int i = 0 ;
        int j = 0;

        while(j < A.length)
        {
            if(A[i] < A[j])
            {
                count--;
                i++;
                
            }
            j++;
            
        }
        return count;
    }
}
