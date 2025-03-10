import java.io.*;

public class B7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.equals("end")) break;

            char[][] board = new char[3][3];
            int x = 0;
            int o = 0;

            for(int i=0; i<9; i++) {
                board[i / 3][i % 3] = input.charAt(i);
                if(input.charAt(i) == 'X') x ++;
                if(input.charAt(i) == 'O') o ++;
            }

            if(o > x || x > o + 1) {
                sb.append("invalid").append("\n");
                continue;
            }

            boolean xWin = false;
            boolean oWin = false;

            for(int i=0; i<3; i++) {
                if(board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                    if(board[i][0] == 'X') xWin = true;
                    if(board[i][0] == 'O') oWin = true;
                }
                if(board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                    if(board[0][i] == 'X') xWin = true;
                    if(board[0][i] == 'O') oWin = true;
                }
            }
            
            if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                if(board[0][0] == 'X') xWin = true;
                if(board[0][0] == 'O') oWin = true;
            }
            
            if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                if(board[0][2] == 'X') xWin = true;
                if(board[0][2] == 'O') oWin = true;
            }

            if(xWin && oWin) {
                sb.append("invalid").append("\n");
                continue;
            }

            if(xWin && x != o + 1) {
                sb.append("invalid").append("\n");
                continue;
            }

            if(oWin && x != o) {
                sb.append("invalid").append("\n");
                continue;
            }

            if(!xWin && !oWin && x + o < 9) {
                sb.append("invalid").append("\n");
                continue;
            }

            sb.append("valid").append("\n");
        }

        System.out.println(sb);
    }
}
