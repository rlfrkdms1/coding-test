import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());

        int[] buildings = new int[N];

        if(a + b - 1 > N) {
            System.out.println(-1);
            System.exit(0);
        }

        Arrays.fill(buildings, 1);

        for(int i = N - 1; i >= N - b; i--) buildings[i] = N - i;

        if(a == 1 && b != N) {
            buildings[0] = buildings[N - b];
            buildings[N - b] = 1;
        } else {
            int range =  N - a - b;
            if(a >= b) for(int i = N - b; i > range; i--) buildings[i] = a--;
            else for(int i = N - b - 1; i > range; i--) buildings[i] = --a;
        }

        StringJoiner answer = new StringJoiner(" ");
        for(int i = 0; i < N; i++) answer.add(String.valueOf(buildings[i]));

        System.out.println(answer.toString());
    }
}
