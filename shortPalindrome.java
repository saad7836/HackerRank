import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the shortPalindrome function below.
    static int shortPalindrome(String s) {
int l = s.length();

        int c=0;
        for(int m=0; m<l-3; m++) 
        {
            for(int n=m+1; n<l-2; n++) 
            {
                for(int o=n+1; o<l-1; o++) 
                {
                    for(int p=o+1; p<l; p++) 
                    {
                       
                        if(s.charAt(m)==s.charAt(p) && s.charAt(n)==s.charAt(o))
                        { 
                            c++;
                        }
                    }
                }
            }
        }
       
       return (c)% (int) ((Math.pow(10,9))+7);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
