package qbobl5.week04;

import java.io.*;

public class B1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        boolean[] arr = new boolean[size];
        int b = 0;
        for(int i=0; i<size; i++) {
            if(input.charAt(i) == 'b') {
                b ++;
                arr[i] = true;
            }
        }
        int a = size - b;

        boolean selected = false;
        int standard = a;
        if(a > b) {
            selected = true;
            standard = b;
        }

        int index = 0;
        for(int i=0; i<size; i++) {
            if(selected == arr[i]) {
                index = i;
                break;
            }
        }

        int max = 0;
        for(int i=index; i<size; i++) {
            if(arr[i] != selected) continue;
            int count = 1;
            for(int j=1; j<standard; j++) if(arr[(i + j) % size] == selected) count ++;
            max = Math.max(max, count);
        }

        System.out.println(Math.max(0, standard - max));
    }
}