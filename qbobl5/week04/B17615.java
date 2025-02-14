package qbobl5.week04;

import java.io.*;

public class B17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        boolean[] bolls = new boolean[N];

        int R = 0;
        int B = 0;
        for(int i=0; i<N; i++) {
            if(input.charAt(i) == 'R') {
                bolls[i] = true;
                R ++;
            } else B ++;
        }

        boolean current = bolls[0];
        int countLeft = 1;
        for(int i=1; i<N; i++) {
            if(bolls[i] != current) break;
            countLeft ++;
        }

        int tmpR = R;
        int tmpB = B;
        if(current) tmpR -= countLeft;
        else tmpB -= countLeft;

        current = bolls[N - 1];
        int countRight = 1;
        for(int i=N-2; i>=0; i--) {
            if(bolls[i] != current) break;
            countRight ++;
        }

        if(current) R -= countRight;
        else B -= countRight;

        System.out.println(Math.min(R, Math.min(B, Math.min(tmpR, tmpB))));
    }
}