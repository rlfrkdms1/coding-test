package hcu55.week05;

import java.io.*;
import java.util.*;

// 컨베이어 벨트 위의 로봇(impl), 골드 V
public class 컨베이어벨트위의로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] strong = new int[N * 2];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            strong[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (true) {
            step++;

            // 벨트 이동
            int lastStrong = strong[N * 2 - 1];
            for (int i = N * 2 - 1; i >= 1; i--) {
                strong[i] = strong[i - 1];
            }
            strong[0] = lastStrong;

            // 로봇 이동
            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            // 뒤에서부터 로봇 이동
            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && strong[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    strong[i + 1]--;
                }
            }
            robot[N - 1] = false;

            // 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇을 올린다.
            if (strong[0] > 0) {
                robot[0] = true;
                strong[0]--;
            }

            // 내구도가 0인 칸 개수가 K개 이상이면 종료
            int cnt = 0;
            for (int s : strong) {
                if (s == 0) cnt++;
            }
            if (cnt >= K) break;
        }

        System.out.println(step);
    }
}
