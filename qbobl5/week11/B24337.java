import java.io.*;
import java.util.*;
import java.lang.*;

public class B24337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        if(a + b > N + 1) {
            System.out.println(-1);
            System.exit(0);
        }

        for(int i=1; i<a; i++) list.add(i);
        list.add(Math.max(a, b));
        for(int i=b-1; i>0; i--) list.add(i);

        if(a == 1) while(list.size() < N) list.add(1, 1);
        else while(list.size() < N) list.add(0, 1);

        StringBuilder sb = new StringBuilder();
        for(int i : list) sb.append(i).append(" ");
        System.out.println(sb);
    }
}
