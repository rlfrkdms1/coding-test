import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String balls = reader.readLine();

        int blues = 0;
        int reds = 0;
        
        //색별 공 개수 세기
        for(int i = 0; i < n; i++) {
            if(balls.charAt(i) == 'B') blues++;
            else reds++;
        }

        //파란공이 오른쪽일 때
        int count = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(balls.charAt(i) == 'R') break;
            count++;
        }
        int rightBlue = blues - count;

        //파란공 왼쪽
        count = 0;
        for(int i = 0; i < n; i++) {
            if(balls.charAt(i) == 'R') break;
            count++;
        }
        int leftBlue = blues - count;

        //빨간공 오른쪽
        count = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(balls.charAt(i) == 'B') break;
            count++;
        }
        int rightRed = reds - count;

        //빨간공 왼쪽
        count = 0;
        for(int i = 0; i < n; i++) {
            if(balls.charAt(i) == 'B') break;
            count++;
        }
        int leftRed = reds - count;

        System.out.println(Math.min(Math.min(rightBlue, leftBlue), Math.min(rightRed, leftRed)));

    }
}
