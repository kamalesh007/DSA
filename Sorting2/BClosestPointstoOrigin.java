// We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).

// Here, the distance between two points on a plane is the Euclidean distance.

// You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

// NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

public class Solution {
    public int[][] solve(int[][] A, int B) {
      int[] distanceArr=new int[A.length];
      ArrayList<Integer> xCor=new ArrayList<Integer>();
      ArrayList<Integer> yCor=new ArrayList<Integer>();

      for(int i=0;i<A.length;i++)
      {
          int[] curPt=A[i];
          int x = curPt[0];
          int y= curPt[1];
          distanceArr[i]=(int)Math.pow(x,2)+(int)Math.pow(y,2);          
      }  
      Arrays.sort(distanceArr);      
      int distValueTobeFound=distanceArr[B-1];
      for(int i=0;i<A.length;i++)
      {
          int[] curPt=A[i];
          int x = curPt[0];
          int y= curPt[1];
          int temp=(int)Math.pow(x,2)+(int)Math.pow(y,2); 
          if(temp <= distValueTobeFound)
          {
              xCor.add(x);
              yCor.add(y);              
          }
      }
      int[][] ans=new int[xCor.size()][2];
      for(int i=0;i<xCor.size();i++)
      {
          int[] temparr=new int[2];
          temparr[0]=xCor.get(i);
          temparr[1]=yCor.get(i);
          ans[i]=temparr;
      }
      return ans;

    }
}
