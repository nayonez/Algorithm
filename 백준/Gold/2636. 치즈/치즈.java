import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Node> queue = new ArrayDeque<>();
    static int deltas[][] = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
    static int R, C, time, cheese;
    static boolean[][] visited;
    static int[][] map;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = 0; cheese = 0;
        R = Integer.parseInt(st.nextToken()); // 세로칸의 수 = 행 = R
        C = Integer.parseInt(st.nextToken()); // 가로칸의 수 = 열 = C

        map = new int[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()); // 1 치즈있음, 0 치즈없음
                if (map[r][c] == 1) {
                    cheese++;
                }
            }
        }
        int chee = 0;
        while (cheese!=0) {
            chee = cheese;
            airbfs(0,0);
            time++;
        }
        System.out.println(time);
        System.out.println(chee);

    }

    private static void airbfs(int r, int c) {
        Queue<Node> queue = new ArrayDeque<>();
        visited = new boolean[R][C];
        queue.offer(new Node(r,c));
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 이 조건체크를 해줄 필요가 없을거 같은데..
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 1) {
                    map[nr][nc] = 0;
                    cheese--;
                    visited[nr][nc] = true;
                }
                else if (map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new Node(nr,nc));
                }
            }
        }
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
