/*
Given an array of integers A, arrange them in an alternate fashion such that every non-negative number is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance. The number of non-negative and negative numbers need not be equal.

If there are more non-negative numbers, they appear at the end of the array. If there are more negative numbers, they also appear at the array's end.

Note: Try solving with O(1) extra space.
*/
public class Solution {
    public int[] solve(int[] A) {
        for(int i = 0 ; i < A.length ; i++)
        {
            if((i % 2) == 0 && A[i] >= 0)            
            {
                int idx=findFirstNegativeElement(A,i+1,A.length);
                if(idx != -1)
                {
                    rightRotate(A,i,idx);
                }
            }
            else if((i & 1) == 1 && A[i] < 0)
            {
               int idx= findFirstPositiveElement(A,i+1,A.length);
               if(idx != -1)
                {
                    rightRotate(A,i,idx);
                }
            }            
        }
        return A;
    }

    public void rightRotate(int[] A,int left, int right)
    {
        while(left != right)
        {
            int temp = A[left];
            A[left] = A[right];
            A[right]=temp;
            left ++;
        }
    }

    public int findFirstNegativeElement(int[] A,int i,int N)
    {
        while(i < N)
        {
            if(A[i]<0)
            {
                return i;
            }
            i++;
        }
        return -1;
    }
    public int findFirstPositiveElement(int[] A,int i,int N)
    {
        while(i < N)
        {
            if(A[i]>=0)
            {
                return i;
            }
            i++;
        }
        return -1;
    }
}
