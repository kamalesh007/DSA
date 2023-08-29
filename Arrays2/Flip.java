// You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

// Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

// If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

// NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
public class Solution {
    public int[] flip(String A) {
        int count=0;
        int[] contributionArray=new int[A.length()];
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='1') count++;
        }
        for(int i=0;i<A.length();i++)
        {
            contributionArray[i]=(A.charAt(i)=='1')?-1:+1;
           // System.out.print(" "+contributionArray[i]+" ");
        }
        if(count==A.length())
        {
            return new int[0];
        }
        return Solution.maxsumSubArray(contributionArray);
    }
    public static int[] maxsumSubArray(int[] arr)
    {
        int maxSum=Integer.MIN_VALUE;
        int R=0;
        int L=0;
        int curSum=0;
        for(int i=0;i<arr.length;i++)
        {
            curSum+=arr[i];
            if(curSum>maxSum)
            {
                R=i;
                maxSum=curSum;
            }
            if(curSum<0)
            {
                curSum=0;
            }
        }
        int tempSum=0;
        for(int i=R;i>=0;i--)
        {
            tempSum+=arr[i];
            if(tempSum==maxSum)
            {
                L=i;
            }
        }
        //System.out.print("sum:"+maxSum);
        return new int[]{L+1,R+1};
    }
}
