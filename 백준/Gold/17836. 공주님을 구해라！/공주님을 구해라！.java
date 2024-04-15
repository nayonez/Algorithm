import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17836 - 공주님을 구해라!
public class Main {
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N, M, T;
    static boolean[][][] visited;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        T = Integer.parseInt(st.nextToken()); // 제한 시간
        visited = new boolean[2][N][M]; // 높이 0 -> 검x 방문,
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = bfs();
        if (answer == -1 || answer > T) System.out.println("Fail");
        else if (answer <= T) System.out.println(answer);
    }
    private static int bfs() {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, false)); // 행, 열의 위치와 검있는지상태
        visited[0][0][0] = true; // 검의 폴스 = 없으면 높이 0에 방문체크
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.r == N-1 && node.c == M-1) return count;
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[node.sword ? 1 : 0][nr][nc]) continue;
                    // 탐색중인게 벽인데 현재 보고 있는 노드의 검 상태가 false면 큐에 X
                    if (map[nr][nc] == 1) {
                        if (!node.sword) continue;
                        else {
                            queue.offer(new Node(nr, nc, true));
                            visited[1][nr][nc] = true;
                        }
                    }

                    else if (map[nr][nc] == 2) {
                        queue.offer(new Node(nr, nc, true));
                        visited[1][nr][nc] = true;
                    }
                    else { // 1, 2 가 아닌.. = 0
                        queue.offer(new Node(nr, nc, node.sword));
                         visited[node.sword ? 1 : 0][nr][nc] = true;
                    }
                }
            } count++;
        } return -1;
    }

    private static class Node {
        int r, c;
        boolean sword;

        public Node(int r, int c, boolean sword) {
            this.r = r;
            this.c = c;
            this.sword = sword;
        }
    }
}
