package hcu55.week07;

import java.io.*;
import java.util.*;

// 빌런 호석(dfs), 골드 V
public class Main {
    static int N, K, P, X;
    static int[][] arr = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  
        K = Integer.parseInt(st.nextToken());  
        P = Integer.parseInt(st.nextToken());  
        X = Integer.parseInt(st.nextToken());   

        dfs(0, 1, 0, 0);
        System.out.println(result - 1);    // 시작 숫자 제외
    }

    // idx = 지금 자리수, placeValue = 몇의 자리인지, nowNum = 지금 숫자, flipCnt = 변경 개수
    public static void dfs(int idx, int placeValue, int nowNum, int flipCnt) {
        if (nowNum > N || flipCnt > P) return; 

        if (idx == K) {
            if (nowNum != 0) result++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(idx + 1, placeValue * 10, i * placeValue + nowNum, flipCnt + arr[X / placeValue % 10][i]);
        }
    }
}
