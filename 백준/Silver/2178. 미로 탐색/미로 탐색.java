import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs로만 dfs는 시간초과
public class Main {
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[][] visited;
    static int N, M, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        bfs(0,0);
        System.out.println(count);
    }

    private static void bfs(int r, int c) {
        count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r,c));
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.r == N-1 && node.c == M-1) {
                    return;
                }
                // 사방탐색 시작
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    if (nr < 0 || nr >= N || nc <0 || nc >= M) // 범위 넘으면
                        continue;
                    if (visited[nr][nc]) // 방문했다면
                        continue;
                    if (map[nr][nc] == '0')
                        continue;
                    queue.offer(new Node(nr,nc));
                    visited[nr][nc] = true;
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
