// Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].

// It is allowed to swap any two elements (not necessarily consecutive).

// Find the minimum number of swaps required to sort the array in ascending order
public class Solution {
    public int solve(int[] A) {
    // CYCLE SIZE N means - (N-1) swaps
    int[] visited = new int[A.length];

    //int i = 0 ;

    int ans = 0;
    for(int i = 0 ; i < A.length ; i ++)
    {
        if(visited[A[i]] == 0)
        {
            int count = 0;
            int ele = A[i];
            while(visited[ele] == 0)
            {
                visited[ele] = 1;
                ele = A[ele];
                count++;
            }
            ans += (count-1);      

        }
    }

    return ans;

    
    }
}
