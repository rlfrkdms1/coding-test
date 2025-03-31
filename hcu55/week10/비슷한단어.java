package hcu55.week10;

import java.io.*;
import java.util.*;

// 비슷한 단어(impl), 골드 IV
public class 비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!list.contains(str)) list.add(str);
        }

        int resultStr1 = 0;
        int resultStr2 = 0;
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            String str1 = list.get(i);
            for (int j = i + 1; j < N; j++) {
                int count = 0;
                String str2 = list.get(j);
                int minSize = Math.min(str1.length(), str2.length());

                for (int k = 0; k < minSize; k++) {
                    if (str1.charAt(k) == str2.charAt(k)) count++;
                    else break;
                }
                if (count > maxCount) {
                    resultStr1 = i;
                    resultStr2 = j;
                    maxCount = count;
                }
            }
        }

        System.out.println(list.get(resultStr1));
        System.out.println(list.get(resultStr2));
    }
}
