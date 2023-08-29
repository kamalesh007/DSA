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
