import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws Exception {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                bfs(i, j);
                count++;
            }
        } sb.append(count).append(" ");

        visited = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                bfs2(i, j);
                count++;
            }
        } sb.append(count);

        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
        int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c));
        visited[r][c] = true;
        // 사방탐색
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >=N) continue;
                if (visited[nr][nc]) continue;
                if (map[r][c]!=map[nr][nc]) continue;

                queue.offer(new Node(nr,nc));
                visited[nr][nc] = true;
            }
        }
    }

    public static void bfs2(int r, int c) {
        int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c));
        visited[r][c] = true;
        // 사방탐색
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >=N) continue;
                if (visited[nr][nc]) continue;
                if (map[r][c] == 'B') {
                    if (map[r][c]!=map[nr][nc]) continue;
                } else {
                    if (map[nr][nc]=='B') continue;
                }

                queue.offer(new Node(nr,nc));
                visited[nr][nc] = true;
            }
        }
    }

    public static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
