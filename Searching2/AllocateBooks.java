// Given an array of integers A of size N and an integer B.

// The College library has N books. The ith book has A[i] number of pages.

// You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

// A book will be allocated to exactly one student.
// Each student has to be allocated at least one book.
// Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
// Calculate and return that minimum possible number.

// NOTE: Return -1 if a valid assignment is not possible.


public class Solution {
    public int books(int[] A, int B) {

        // Exception CASE :

        if(B > A.length) // Some students cant be allocated books if #students > #Books
        {
            return -1;
        }

        // If # books == # students ; Every student one book ; so minimized max pages = Max(books)
        // If  1 == # students ; One student all book ; so minimized max pages = Sum(books)

        long max = 0;
        long sum = 0;
        for(int i = 0;i<A.length ; i++)
        {
            sum = sum + A[i];
            max = Math.max(A[i],max);
        }  

        long low = max ;
        long high = sum ;

        while(low <= high)
        {
            long mid = low + ((high - low)/2);
            boolean allocate = allocateMaxPages(mid,A,B);
            if(allocate)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1 ;
            }

        }
        return (int)low ;
    }

    public boolean allocateMaxPages(long maxPagePerStudent, int[] A,int students)
    {
        long pages = 0;
        int noOfStudentsAllocated = 1;
        for(int i = 0 ; i < A.length ; i++)
        {
            pages = pages + A[i];
            if(pages <= maxPagePerStudent) // Check for next book
            {
                continue;
            }
            else // Current no of pages cannot be assigned ; so assign this current book to the next student
            {
                pages = A[i]; // assign current book
                noOfStudentsAllocated ++; // to next sutdent
            }
            if(noOfStudentsAllocated > students) // If numberofstudents needed becomes greater than the max student means that this allocation is not possible and we need more students to allocate this maxPages so value is too low.
            {
                return false;
            }   
        }
        return true;
    }
}
