package hcu55.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 타노스(string), 실버 III
public class 타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }
        zeroCnt /= 2;
        oneCnt /= 2;

        int i = 0;
        while (oneCnt != 0) {
            if (s.charAt(i) == '1') {
                s = s.substring(0, i) + s.substring(i + 1);
                oneCnt--;
            } else {
                i++;
            }
        }

        int j = s.length() - 1;
        while (zeroCnt != 0) {
            if (s.charAt(j) == '0') {
                s = s.substring(0, j) + s.substring(j + 1);
                zeroCnt--;
                j--;
            } else {
                j--;
            }
        }
        System.out.println(s);
    }
}
