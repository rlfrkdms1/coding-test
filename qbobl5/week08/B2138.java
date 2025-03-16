import java.io.*;

public class B2138 {
    static int[] result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String start = br.readLine();
        String target = br.readLine();
        
        int[] startOn = new int[N];
        int[] startOff = new int[N];
        result = new int[N];

        for(int i=0; i<N; i++) {
            startOn[i] = Integer.parseInt(start.charAt(i)+"");
            startOff[i] = startOn[i];
            result[i] = Integer.parseInt(target.charAt(i)+"");
        }

        int on = 0;
        int off = 0;
        
        if(startOn[0] != 0) {
            startOn[0] = 1 - startOn[0];
            startOn[1] = 1 - startOn[1];
            on = check(1, startOn);
            off = check(0, startOff);
        } else {
            on = check(0, startOn);
            startOff[0] = 1 - startOff[0];
            startOff[1] = 1 - startOff[1];
            off = check(1, startOff);
        }

        if(on == -1  && off == -1) sb.append("-1").append("\n");
        else if(on == -1) sb.append(off).append("\n");
        else if(off == -1) sb.append(on).append("\n");
        else sb.append(Math.min(on, off)).append("\n");

        System.out.println(sb);
    }

    private static int check(int count, int[] current) {
        for(int i=1; i<current.length; i++) {
            if(result[i - 1] == current[i - 1]) continue;
            count ++;
            current[i] = 1 - current[i];
            current[i - 1] = 1 - current[i - 1];
            if(current.length - 1 > i) current[i + 1] = 1 - current[i + 1];
        }

        if(result[current.length - 1] == current[current.length - 1]) return count;
        return -1;
    }
}
