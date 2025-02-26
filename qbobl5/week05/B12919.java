import java.io.*;
import java.lang.*;

public class B12919 {
    static String target;
   
    static void compareString(StringBuilder current) {
        if(current.length() == target.length()) {
            if(current.toString().equals(target)) System.out.println(1);
            else return;
            System.exit(0);
        }
        if(current.charAt(0) == 'A') {
            if(current.charAt(current.length() - 1) == 'B') {
                System.out.println(0);
                System.exit(0);
            } else current.deleteCharAt(current.length() - 1);
        } else {
            if(current.charAt(current.length() - 1) == 'A') {
                StringBuilder temp = new StringBuilder().append(current);
                temp.deleteCharAt(temp.length() - 1);
                compareString(temp);
            }
            current.deleteCharAt(0);
            current.reverse();
        }
        compareString(current);
    }
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        StringBuilder start = new StringBuilder(br.readLine());
        compareString(start);
        System.out.println(0);
    }
}
