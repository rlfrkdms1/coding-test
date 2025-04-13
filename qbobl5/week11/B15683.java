import java.io.*;
import java.util.*;

public class B15683 {
    static class CCTV {
		char type;
		int direction;
		int view[][];
		int time;
		int row;
		int col;
		
		CCTV(char type, int row, int col) {
			this.type = type;
			this.row = row;
			this.col = col;
			if(type == '1') {
				this.view = new int[][] {{0, -1}};
				this.time = 4;
			} else if(type == '2') {
				this.view = new int[][] {{0, -1}, {0, 1}};
				this.time = 2;
			} else if(type == '3') {
				this.view = new int[][] {{0, 1}, {-1, 0}};
				this.time = 4;
			} else if(type == '4') {
				this.view = new int[][] {{0, -1}, {0, 1}, {-1, 0}};
				this.time = 4;
			} else if(type == '5') {
				this.view = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
				this.time = 1;
			}
		}
	}
    
	static char map[][];
	static List<CCTV> list = new ArrayList<>();
	static int N;
    static int M;
    static int size;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int room = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == '0') {
                    room ++;
                    continue;
                }
                if(map[i][j] != '6') list.add(new CCTV(map[i][j], i, j));
			}
		}
		
		watch(0);
		System.out.println(room - size);
	}

    static void watch(int n) {
		if(n == list.size()) {
			int sum = 0;
			char temp[][] = new char [N][M];
			for(int i=0; i<N; i++) for(int j=0; j<M; j++) temp[i][j] = map[i][j];
			for(int i=0; i<list.size(); i++) execute(i, temp);
			for(int i=0; i<N; i++) for(int j=0; j<M; j++) if(temp[i][j] == '#') sum ++;
			size = Math.max(size, sum);
			return;
		}
        
		for(int j=0; j<list.get(n).time; j++) {
			list.get(n).direction = j;
			watch(n + 1);
		}
	}
	
	static void execute(int index, char map[][]) {
		int temp[][] = list.get(index).view;
		for(int i=0; i<temp.length; i++) {
			int r = list.get(index).row;
            int c = list.get(index).col;
            
			while(true) {
				if(list.get(index).direction == 0) {
					r += temp[i][0];
					c += temp[i][1];
				} else if(list.get(index).direction == 1) {
					r -= temp[i][1];
					c += temp[i][0];
				} else if(list.get(index).direction == 2) {
					r -= temp[i][0];
					c -= temp[i][1];
				} else if(list.get(index).direction == 3) {
					r += temp[i][1];
					c -= temp[i][0];
				}
				
				if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == '6') break;
				else if(map[r][c] == '0') map[r][c] = '#';
			}
		}
	}
}
