// Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

// The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

// Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

// Find and return the required subarray.

// NOTE:

//     1. If there is a tie, then compare with segment's length and return segment which has maximum length.
//     2. If there is still a tie, then return the segment with minimum starting index.

public class Solution {
    public int[] maxset(int[] A) {
       
	       long maxSum = 0;
	       long sum = 0;
	       int l=0;   
	       int r = -1;
	       int finalL=0;          
	       for(int i=0;i<A.length;i++)
	       {
	           if(A[i]>=0)
	           {
	               sum = sum + A[i];
	           }
	           else if(A[i]<0)
	           {
	               if(sum > maxSum)
	               {
	                   maxSum = sum ;
	                   finalL = l;
	                   r = i-1;
	                   
	               }
	               else if(sum == maxSum)
	               {
	            	   int existingLen = r -finalL +1;
	    	           int currentLen = i - 1 - l + 1;
	    	           if(existingLen < currentLen)
	    	           {
	    	        	   finalL = l;
	    	        	   r = i-1;
	    	           }
	               }
	               sum = 0;
	               l = i + 1;
	               
	           }
	       }
	       if(sum > maxSum)
	       {
	           finalL = l;
	           r = A.length - 1;
	       }
	       else if(sum == maxSum)
	       {
	           int existingLen = r -finalL +1;
	           int currentLen = A.length - 1 - l + 1;
	           if(currentLen > existingLen)
	           {
	               finalL = l;
	               r = A.length - 1;
	           }
	       }
	       //System.out.println(finalL +"\t"+ r);return new int[0];
           if(r - finalL+1<=0)
           {
               return new int[0];
           }
           else
           {
               int[] ans=new int[r-finalL+1];
               for(int i=0;i<ans.length;i++)
               {
                   ans[i]=A[finalL++];
               }
               return ans;
           }
	    
    }
    
}
