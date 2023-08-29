// Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.

// For example:

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 

public class Solution {
    public String convertToTitle(int A) {        
        int base = 26;
        String k = "";
        do{
            int temp = ((A-1) % 26) + 65;
            char x = (char) temp;
            A = ((A-1)/26);
            k = x + k;
        }while(A > 0);
        return k;   
    }
}
