package hcu55.week01;

import java.io.*;
import java.util.*;

// 가희와 키워드(set), 실버 III
public class 가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> memoSet = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            memoSet.add(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            String[] keywords = br.readLine().split(",");
            for (String keyword : keywords) {
                memoSet.remove(keyword);
            }
            System.out.println(memoSet.size());
        }
    }
}
