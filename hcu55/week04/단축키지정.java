package hcu55.week04;

import java.io.*;
import java.util.*;

// 단축키 지정(impl), 실버 I
public class 단축키지정 {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<Character> shortcuts = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            boolean shortcutCheck = false;

            for (int j = 0; j < strArr.length; j++) {
                char firstChar = Character.toLowerCase(strArr[j].charAt(0));
                if (!shortcuts.contains(firstChar)) {
                    shortcuts.add(firstChar);
                    strArr[j] = "[" + strArr[j].charAt(0) + "]" + strArr[j].substring(1);
                    shortcutCheck = true;
                    break;
                }
            }

            if (!shortcutCheck) {
                for (int j = 0; j < strArr.length; j++) {
                    for (int k = 0; k < strArr[j].length(); k++) {
                        char c = Character.toLowerCase(strArr[j].charAt(k));
                        if (!shortcuts.contains(c)) {
                            shortcuts.add(c);
                            strArr[j] = strArr[j].substring(0, k) + "[" + strArr[j].charAt(k) + "]" + strArr[j].substring(k + 1);
                            shortcutCheck = true;
                            break;
                        }
                    }
                    if (shortcutCheck) break;
                }
            }
            sb.append(String.join(" ", strArr)).append("\n");
        }
        System.out.print(sb);
    }
}
