package hcu55.week04;

import java.io.*;
import java.util.*;

// 문자열 교환(sliding window), 실버 I
public class 문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int aCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCnt++;
            }
        }

        int min = Integer.MAX_VALUE;
        int bCnt;
        for (int i = 0; i < str.length(); i++) {
            bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                if (str.charAt(j % str.length()) == 'b') {
                    bCnt++;
                }
            }
            min = Math.min(min, bCnt);
        }
        System.out.println(min);
    }
}
