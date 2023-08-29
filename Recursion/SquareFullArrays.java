// Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

// Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

public class Solution {
    
    public int ans;
    public HashMap<Integer,Integer> fMap;
    public int solve(int[] A) {
        fMap = new HashMap<Integer,Integer>();
        ans = 0;
        int N = A.length;        
        if(N == 1)
        {
            return (isPerfectSq(A[0]))?1:0;
        }
        for(int i = 0 ; i < N ; i++)
        {
            int count = fMap.getOrDefault(A[i],0);
            fMap.put(A[i],count+1);
        }
        squareFull(new int[N],0,N);
        return ans;
    }  

    public void squareFull(int[] arr,int index,int N)
    {
        // Base cases
        if(index == N)
        {
            ans++;
            return;
        }

        for(Integer choice : fMap.keySet()) // All Possibilities
        {
            int count = fMap.get(choice);
            if(count > 0) // Valid Possibilities
            {
                if(index == 0 || isPerfectSq(arr[index-1] + choice)) // Valid Possibilities
                {
                    arr[index] = choice; // Do
                    fMap.put(choice,count - 1); // Do
                    squareFull(arr,index+1,N ); // Recursion
                    fMap.put(choice,count); // BackTrack                  
                }
            }
        }

    }

    public boolean isPerfectSq(int num)
    {
        int x = (int)Math.sqrt(num);
        return ((x * x) == num);
    }  
}


