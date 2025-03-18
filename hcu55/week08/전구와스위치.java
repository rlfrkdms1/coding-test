package hcu55.week08;

import java.io.*;
import java.util.*;

// 전구와 스위치(impl), 골드 IV
public class 전구와스위치 {
    static int N;
    static int[] current;
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String str1 = br.readLine();
        String str2 = br.readLine();
        
        current = new int[N];
        for (int i = 0; i < N; i++) {
            current[i] = str1.charAt(i) - '0';
        }

        target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = str2.charAt(i) - '0';
        }

        int nofirstClick = solve(false);
        int firstClick = solve(true);
        int answer = -1;

        if (nofirstClick != -1 && firstClick != -1) {
            answer = Math.min(nofirstClick, firstClick);
        } else if (nofirstClick != -1) {
            answer = nofirstClick;
        } else if (firstClick != -1) {
            answer = firstClick;
        }

        System.out.println(answer);
    }

    public static int solve(boolean first) {
        int[] arr = current.clone();
        int pressCount = 0;

        if (first) {
            click(arr, 0);
            pressCount++;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != target[i - 1]) {
                click(arr, i);
                pressCount++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] != target[i]) {
                return -1;
            }
        }

        return pressCount;
    }

    public static void click(int[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (idx - 1 >= 0) {
                arr[idx - 1] = arr[idx - 1] == 0 ? 1 : 0;
            }
            
            arr[idx] = arr[idx] == 0 ? 1 : 0;
            
            if (idx + 1 < N) {
                arr[idx + 1] = arr[idx + 1] == 0 ? 1 : 0;
            }
        }
    }
}
