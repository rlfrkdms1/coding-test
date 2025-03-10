import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner answer = new StringJoiner(System.lineSeparator());
        
        while(true) {
            String status = reader.readLine();
            if(status.equals("end")) break;                
            answer.add(isValidGame(status) ? "valid" : "invalid");
        }

        System.out.println(answer.toString());
    }

    static private boolean isValidGame(String status) {

        boolean isXWin = false;
        boolean isOWin = false;
        int xCount = 0;
        int oCount = 0;
        int sequence = 1;
        
        for(int i = 0; i < 9; i++) {
            if(status.charAt(i) == 'X') xCount++;
            if(status.charAt(i) == 'O') oCount++;
        }

        for(int i = 0; i < 3; i++) {
            // 가로 검사 
            if(status.charAt(i * 3) == status.charAt(i * 3 + 1) && status.charAt(i * 3) == status.charAt(i * 3 + 2)) {
                if(status.charAt(i * 3) == 'X') isXWin = true;
                if(status.charAt(i * 3) == 'O') isOWin = true;
            }

            // 세로 검사
            if(status.charAt(i) == status.charAt(i + 3) && status.charAt(i) == status.charAt(i + 6)) {
                if(status.charAt(i) == 'X') isXWin = true;
                if(status.charAt(i) == 'O') isOWin = true;
            }
        }

        //대각선 검사
        if(status.charAt(4) == status.charAt(0) && status.charAt(4) == status.charAt(8) || 
                  status.charAt(4) == status.charAt(2) && status.charAt(4) == status.charAt(6)) {
            if(status.charAt(4) == 'X') isXWin = true;
            if(status.charAt(4) == 'O') isOWin = true;
        }

        if(xCount > oCount + 1) return false;
        if(isXWin && xCount != oCount + 1) return false;
        if(isOWin && xCount != oCount) return false;
        if(!(isXWin || isOWin) && (xCount != 5 || oCount != 4)) return false;
        
        return true;
        
    }
}
