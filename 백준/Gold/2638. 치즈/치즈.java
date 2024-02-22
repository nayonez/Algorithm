import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2638 - 치즈
public class Main {
    static int[][] map;
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static int cheese, time, N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new int[N][M];
        cheese = 0;
        time = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++; // 지도 값 1일때마다 cheese값 증가
            }
        }

        // 치즈가 다 없어질때까지, 외부 공기 체크 -> 치즈 녹이기 반복
        while (cheese > 0) {
            OutAirCheck(0, 0);
            melt();
            time++;
        }
        System.out.println(time);
    }

    private static void OutAirCheck(int r, int c) { // 0,0 은 공기니까 여기서부터 시작
        Queue<Node> queue = new ArrayDeque<>(); // 외부공기 체크할 때마다 큐 초기화
        boolean[][] visited = new boolean[N][M]; // 방문체크도 초기화

        queue.offer(new Node(r,c));
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[nr][nc]) continue;
                    if (map[nr][nc] >= 1) {
                        map[nr][nc] += 5; // 한번당 그 칸에 5씩 더해줘서 10 이상이 되면 치즈 녹여도 됨
                        if (map[nr][nc] > 10) {
                            visited[nr][nc] = true;
                        }
                    } else { // 주변 노드가 0일때만 큐에 offer함
                        queue.offer(new Node(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }

        }
    }

    private static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 10) {
                    map[i][j] = 0;
                    cheese--;
                } else if (map[i][j] > 0) { // 치즈가 있는 상태면(한면 만 접촉했다면 원복
                    //다시 air체크하면서 두면 접촉한곳은 10이상 됨
                    map[i][j] = 1;
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
