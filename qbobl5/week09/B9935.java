import java.io.*;

public class B9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        int size = bomb.length();

        for(int i=0; i<word.length(); i++) {
            sb.append(word.charAt(i));
            if(sb.length() >= size) {
                boolean flag = true;
                int sub = sb.length() - size;
                for(int j=0; j<size; j++) {
                    if(sb.charAt(sub + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) sb.setLength(sb.length() - size);
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
