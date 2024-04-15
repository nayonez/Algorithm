import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;
    static boolean[][][] visited;
    static int[][] map;
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}, // d = 0 1 2 3 -> 4방 상하좌우 
            {-1,-2}, {-2,-1}, {1,-2}, {2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}}; // d = 4 5 6 7 8 9 10 11 -> 8방 말의 L위치
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 말처럼 움직일 수 있는 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 가로길이 = 열
        H = Integer.parseInt(st.nextToken()); // 세로길이 = 행
        map = new int[H][W];
        visited = new boolean[K+1][H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs()); // 0,0에서 h-1,w-1까지 가야함
    }
    private static int bfs() {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0,0,0)); // 시작 0,0에서 말로 움직인거 0번으로
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.r == H-1 && node.c == W-1) return count;
                for (int d = 0; d < 12; d++) {
                    if (d==4 && node.count >= K) break; // node.count=말로 이동할수있는 횟수 채웠으면 말로 L로 갈수있는 위치는 보지X
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == 1) continue; // 장애물이면 패스
                    if (d >= 4) { // 말일때
                        if (visited[node.count+1][nr][nc]) continue; // 방문했으면 패스
                        else {
                            queue.offer(new Node(nr,nc,node.count+1));
                            visited[node.count+1][nr][nc] = true;
                        }
                    }
                    else {
                        if (visited[node.count][nr][nc]) continue;
                        else {
                            queue.offer(new Node(nr,nc,node.count));
                            visited[node.count][nr][nc] = true;
                        }
                    }
                }
            } count++;
        } return -1;
    }
    private static class Node {
        int r, c, count;
        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}
