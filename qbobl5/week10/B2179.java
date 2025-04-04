import java.io.*;

public class B2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for(int i=0; i<N; i++) words[i] = br.readLine();

        int max = 0;
        int S = 0;
        int T = 0;
        
        for(int i=0; i<N-1; i++) {
            String current = words[i];
            
            for(int j=0; j<N; j++) {
                if(i == j) continue;
                String target = words[j];
                
                int count = 0;
                int size = Math.min(current.length(), target.length());
                for(int k=0 ; k<size ; k++) {
                    if(current.charAt(k) != target.charAt(k)) break;
                    count++;
                }

                if(max < count) {
                    max = count;
                    S = i;
                    T = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(words[S]).append("\n").append(words[T]);
        System.out.println(sb);
    }
}
