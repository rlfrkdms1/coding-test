import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numbers = reader.readLine();

        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < numbers.length(); i++) {
            if(numbers.charAt(i) == '1') count1++;
            else count0++;
        }

        StringBuilder builder = new StringBuilder(numbers);
        String reverseNumbers = builder.reverse().toString();
        for(int i = 0; i < count0/2; i++) {
            reverseNumbers = reverseNumbers.replaceFirst("0", "");
        }
        
        numbers = new StringBuilder(reverseNumbers).reverse().toString();
        for(int i = 0; i < count1/2; i++) {
            numbers = numbers.replaceFirst("1", "");
        }

        System.out.println(numbers);
    }
}
