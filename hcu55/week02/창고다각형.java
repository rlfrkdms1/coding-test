package hcu55.week02;

import java.io.*;
import java.util.*;

// 창고 다각형(impl), 실버 II
public class 창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        Collections.sort(list, (a, b) -> a[0] - b[0]);

        int maxHeight = 0, maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (list.get(i)[1] > maxHeight) {
                maxHeight = list.get(i)[1];
                maxIdx = i;
            }
        }

        int result = 0;

        int leftMaxIdx = list.get(0)[0];        
        int leftMaxHeight = list.get(0)[1];
        for (int i = 1; i <= maxIdx; i++) {
            if (list.get(i)[1] > leftMaxHeight) {
                result += (list.get(i)[0] - leftMaxIdx) * leftMaxHeight;
                leftMaxHeight = list.get(i)[1];
                leftMaxIdx = list.get(i)[0];
            }
        }

        int rightMaxIdx = list.get(N - 1)[0];
        int rightMaxHeight = list.get(N - 1)[1];
        for (int i = N - 2; i >= maxIdx; i--) {
            if (list.get(i)[1] > rightMaxHeight) {
                result += (rightMaxIdx - list.get(i)[0]) * rightMaxHeight;
                rightMaxHeight = list.get(i)[1];
                rightMaxIdx = list.get(i)[0];
            }
        }
        
        // 가장 높은 기둥의 면적 추가 -> 이거 때매 계속 틀림
        int maxStartX = list.get(maxIdx)[0];
        int maxEndX = maxStartX;

        for (int i = 0; i < N; i++) {
            if (list.get(i)[1] == maxHeight) {
                maxStartX = Math.min(maxStartX, list.get(i)[0]);
                maxEndX = Math.max(maxEndX, list.get(i)[0]);
            }
        }

        result += (maxEndX - maxStartX + 1) * maxHeight;
        System.out.println(result);
    }
}
