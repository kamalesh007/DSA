// Given a array of integers A of size N and an integer B.

// Return number of non-empty subsequences of A of size B having sum <= 1000.


public class Solution {
    public int ans=0;
    public int solve(int[] A, int B) {
        fun(A,B,0,0,0);
        return this.ans;
    }
    public void fun(int[] arr,int B,int sum,int count,int index)
    {
        if(sum>1000)
        {
            return;
        }
        if(count==B)
        {
            this.ans=this.ans+1;
            return;
        }
        if(index==arr.length)
        {
            return;
        }
        fun(arr,B,sum+arr[index],count+1,index+1);
        fun(arr,B,sum,count,index+1);
    }
}
