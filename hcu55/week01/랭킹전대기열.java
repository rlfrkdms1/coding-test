package hcu55.week01;

import java.io.*;
import java.util.*;

// 랭킹전 대기열(implementation), 실버 II
public class 랭킹전대기열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean joined = false;
            for (Room room : rooms) {
                if (room.canJoin(level, m)) {
                    room.players.add(new Player(level, name));
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                rooms.add(new Room(level, name));  // 새로운 방 생성
            }
        }

        for (Room room : rooms) {
            Collections.sort(room.players);
            System.out.println(room.players.size() == m ? "Started!" : "Waiting!");
            for (Player player : room.players) {
                System.out.println(player.level + " " + player.name);
            }
        }
    }

    static class Player implements Comparable<Player> {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player other) {
            return this.name.compareTo(other.name);  // 닉네임 기준 사전순 정렬
        }
    }

    static class Room {
        int minLevel;
        int maxLevel;
        List<Player> players = new ArrayList<>();

        public Room(int level, String name) {
            this.minLevel = level - 10;
            this.maxLevel = level + 10;
            players.add(new Player(level, name));
        }

        boolean canJoin(int level, int maxPlayers) {
            return players.size() < maxPlayers && level >= minLevel && level <= maxLevel;
        }
    }
}
