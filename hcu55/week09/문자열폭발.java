package hcu55.week09;

import java.io.*;
import java.util.*;

// 문자열 폭발(stack), 골드 IV
public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bomb = br.readLine();

        int bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bombLen) {
                boolean check = true;
                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        check = false;
                        break;
                    }
                }

                if (check) sb.delete(sb.length() - bombLen, sb.length());
            }
        }

        if (sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());
    }
}
