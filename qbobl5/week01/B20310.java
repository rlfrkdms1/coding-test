package qbobl5.week01;
import java.io.*;

public class B20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int zeroCount = 0;
        int oneCount = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length(); i++) {
            char number = S.charAt(i);
            sb.append(number);
            if(number == '0') zeroCount ++;
            else oneCount ++;
        }

        zeroCount /= 2;
        oneCount /= 2;

        int index = 0;
        while(oneCount > 0) {
            if(S.charAt(index) == '1') {
                sb.delete(index, index + 1);
                S = sb.toString();
                oneCount --;
            } else index ++;
        }

        index = S.length() - 1;
        while(zeroCount > 0) {
            if(S.charAt(index) == '0') {
                sb.delete(index, index + 1);
                S = sb.toString();
                zeroCount --;
            }
            index --;
        }

        System.out.println(sb.toString());
    }
}