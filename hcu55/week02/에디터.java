package hcu55.week02;

import java.io.*;
import java.util.*;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        String str = br.readLine();
        for (String s : str.split("")) {
            left.push(s);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // nextToken()을 한 번만 호출
            if (command.equals("L") && !left.isEmpty()) {
                right.push(left.pop());
            } else if (command.equals("D") && !right.isEmpty()) {
                left.push(right.pop());
            } else if (command.equals("B") && !left.isEmpty()) {
                left.pop();
            } else if (command.equals("P")) {
                left.push(st.nextToken());
            }
        }

        for (String s : left) {
            sb.append(s);
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.print(sb);
    }
}
