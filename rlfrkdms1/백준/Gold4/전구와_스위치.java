import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        length = Integer.parseInt(reader.readLine());
        String N1 = reader.readLine();
        String N2 = reader.readLine();
        
        boolean[] goal = new boolean[length];
        boolean[] temp1 = new boolean[length];
        boolean[] temp2 = new boolean[length];
        for(int i = 0; i < length; i++) {
            goal[i] = N1.charAt(i) == '1' ? true : false;
            boolean temp = N2.charAt(i) == '1' ? true : false;
            temp1[i] = temp;
            temp2[i] = i == 0 || i == 1 ? !temp : temp;
        }

        // 첫번째 스위치를 누르지 않는 경우
        int count1 = switching(temp1, goal, 0);
        // 첫번째 스위치 누른 경우
        int count2 = switching(temp2, goal, 1);
                
        if(count1 != -1 && count2 != -1) System.out.println(Math.min(count1, count2));
        else System.out.println(Math.max(count1, count2));
        
    }

    private static int switching(boolean[] temp, boolean[] goal, int count) {
        for(int i = 1; i < length; i++) {
            if(temp[i - 1] ^ goal[i - 1]) {
                temp[i - 1] = !temp[i - 1];
                temp[i] = !temp[i];
                if(i + 1 < length) temp[i + 1] = !temp[i + 1];
                count++;
            }
        }
        return temp[0] == goal[0] && temp[length - 1] == goal[length - 1] ? count : -1;
    }
}
