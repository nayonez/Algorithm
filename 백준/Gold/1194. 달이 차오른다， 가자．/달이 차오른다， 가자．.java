import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1194 - 달이 차오른다, 가자.
public class Main {
    static boolean[][][] visited;
    static char[][] map;
    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int N, M;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        int r = 0;
        int c = 0;
        map = new char[N][M];
        visited = new boolean[1<<6][N][M]; // 1<<아이템의개수만큼(여기서는 키의 종류)
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (temp.charAt(j) == '0') {
                    r = i;
                    c = j;
                }
                map[i][j] = temp.charAt(j);
            }
        }
        System.out.println(bfs(r,c));
    }

    private static int bfs(int r, int c) {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c, 0)); // 처음엔 키 0개이고 행 열 0,0으로
        visited[0][r][c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (map[node.r][node.c] == '1') return count;
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    int nk = node.key;
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[nk][nr][nc]) continue;
                    if (map[nr][nc]=='#') continue;
                    // 열쇠일때
                    if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
                        nk = node.key | 1 << (map[nr][nc] - 'a');
                    } // 문일때
                    else if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
                        if ((node.key & 1 << map[nr][nc] - 'A') == 0) {
                            continue;
                        }
                    }
                    queue.offer(new Node(nr,nc,nk));
                    visited[nk][nr][nc] = true;

                }
            }
            count++;
        }
        return -1;
    }
    private static class Node {
        int r, c, key;
        public Node(int r, int c, int key) {
            this.r = r;
            this.c = c;
            this.key = key;
        }
    }
}
