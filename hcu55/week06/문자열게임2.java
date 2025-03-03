package hcu55.week06;

import java.io.*;
import java.util.*;

/// 문자열 게임 2(sliding_window), 골드 V
public class 문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < W.length(); i++) {
                char first = W.charAt(i);
                map.putIfAbsent(first, new ArrayList<>());
                map.get(first).add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for (char c : map.keySet()) {
                List<Integer> indexList = map.get(c);
                if (indexList.size() < K) continue;

                for (int i = 0; i <= indexList.size() - K; i++) {
                    int length = indexList.get(i + K - 1) - indexList.get(i) + 1;
                    minLen = Math.min(minLen, length);
                    maxLen = Math.max(maxLen, length);
                }
            }

            if (maxLen == -1) {
                System.out.println("-1");
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}
