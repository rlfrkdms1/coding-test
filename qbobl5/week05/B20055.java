import java.io.*;
import java.util.*;

public class B20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[2 * N];
        boolean[] isRobot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<belt.length; i++) belt[i] = Integer.parseInt(st.nextToken());

        int level = 0;
        int count = 0;
        
        while(K > 0) {
            level ++;
            int end = belt[belt.length - 1];
            for(int i=belt.length-1; i>0; i--) belt[i] = belt[i - 1];
            belt[0] = end;
            for(int i=N-1; i>0; i--) isRobot[i] = isRobot[i - 1];
            isRobot[0] = false;
            isRobot[N - 1] = false;
            
            for(int i=N-2; i>=0; i--) {
                if(isRobot[i] && !isRobot[i + 1] && belt[i + 1] > 0) {
                    isRobot[i] = false;
                    isRobot[i + 1] = true;
                    belt[i + 1] --;
                    if(belt[i + 1] == 0) K --;
                }
            }
            isRobot[N - 1] = false;
            
            if(belt[0] > 0) {
                isRobot[0] = true;
                belt[0]--;
                if(belt[0] == 0) K --;
            }
        }
        
        System.out.println(level);
    }
}
