import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569 - 토마토
public class Main {
    static int[][] deltas =
            {{0,-1,0}, {0,1,0}, {0,0,-1}, {0,0,1}, {1,0,0}, {-1,0,0}};
    static int[][][] map;
    static int M,N,H,count;
    static int max = Integer.MIN_VALUE;
    static Queue<Node> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        //정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 칸의 수 = 열
        N = Integer.parseInt(st.nextToken()); // 세로 칸의 수 = 행
        H = Integer.parseInt(st.nextToken()); // 쌓아올려진 상자의 수 = 높이
        count = 0;
        map = new int[H][N][M]; // 높이, 행, 열
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    map[h][r][c] = Integer.parseInt(st.nextToken());
                    if (map[h][r][c] == 1) // 익은 토마토면 큐에 다 넣어주기
                        queue.offer(new Node(h,r,c));
                }
            }
        }
        bfs();
        System.out.println(ans());
    }

    private static int ans() {
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if(map[h][r][c] > 0) {
                        max = Math.max(max, map[h][r][c]);
                    }
                    else if(map[h][r][c] == 0) {
                        return -1;
                    }
                }
            }
        } return max - 1;
    }
    private static void bfs() {

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node node = queue.poll();
                for (int d = 0; d < 6; d++) {
                    int nh = node.h + deltas[d][0];
                    int nr = node.r + deltas[d][1];
                    int nc = node.c + deltas[d][2];
                    if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nh][nr][nc] == -1) continue;
                    if (map[nh][nr][nc] == 0) {
                        map[nh][nr][nc] = map[node.h][node.r][node.c] + 1;
                        queue.offer(new Node(nh,nr,nc)); // 큐에 넣고 .. 익은토마토가 됐으니 기준으로 또 탐색해야 day누적
                    }
                }
            }
        }
    }

    private static class Node {
        int h,r,c;
        public Node(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
}
