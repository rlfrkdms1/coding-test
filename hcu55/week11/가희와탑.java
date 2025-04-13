package hcu55.week11;

import java.io.*;
import java.util.*;

// 가희와 탑(impl), 골드 III
public class 가희와탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        List<Integer> building = new ArrayList<>();

        if (a + b - 1 > N) {
            System.out.print(-1);
            return;
        }

        for (int i = 1; i < a; i++) {
            building.add(i);
        }
        building.add(Math.max(a, b));

        for (int i = b - 1; i >= 1; i--) {
            building.add(i);
        }

        if (a == 1) {
            while (building.size() < N) {
                building.add(1, 1);
            }
        } else {
            while (building.size() < N) {
                building.add(0, 1);
            }
        }
        
        for (int i : building) {
            System.out.print(i + " ");
        }
    }
}
