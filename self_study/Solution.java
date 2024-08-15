import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String sul = "";
        for(char c : a.toCharArray())
        {
            if(c>=65 && c<=90)
                sul += (char)(c+32);
            else
                sul += (char)(c-32);
        }
        
         System.out.println(sul);
    }

}
