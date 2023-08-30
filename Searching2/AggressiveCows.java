// Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

// His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
public class Solution {
    public int solve(int[] A, int B) {
        
        

        int ans=0;
        Arrays.sort(A);
        int low=0;
        int high=(A[A.length-1] - A[0])/(B-1);
        // for(int i=0;i<A.length;i++)
        // {
        //     System.out.print(A[i]+"--");
        // }
        while(low<=high)
        {
            int mid=low+((high-low)/2);
           // System.out.println(mid);
            if(check(mid,A,B))
            {
                low=mid+1;
                ans=mid;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
        
    }
    public boolean check(int distance,int[] A,int cows)
    {
        int gap=0;
        // for(int i=0;i<A.length;i++)
        // {
        //     System.out.print(A[i]+"--");
        // }
        for(int i=1;i<A.length;i++)
        {
           gap=gap+(A[i]-A[i-1]);
           if(gap>=distance)
           {
               cows--;
               gap=0;
           }
           
        }
        if(cows<=1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
