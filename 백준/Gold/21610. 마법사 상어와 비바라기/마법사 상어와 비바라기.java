import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21610 - 마법사 상어와 비바라기
public class Main {
    static int N, M;
    static int[][] deltas = {{0,-1},{-1,-1},{-1,0},{-1,1},
            {0,1}, {1,1}, {1,0}, {1,-1}}; // 좌 -> 시계방향으로 8방! 좌0,상2,우4,하6
    static Queue<Node> queue;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 구름 이동 반복 횟수
        map = new int[N][N];
        // 초기 맵 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new ArrayDeque<>(); // 구름정보 저장

        // 큐에 초기 구름 위치 저장 (N, 1), (N, 2), (N-1, 1), (N-1, 2)
        queue.offer(new Node(N-1, 0));
        queue.offer(new Node(N-1, 1));
        queue.offer(new Node(N-2, 0));
        queue.offer(new Node(N-2, 1));

        // 구름 이동 정보(d 방향, s 칸)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            visited = new boolean[N][N]; // 맵과 같은 크기, 구름이 사라지면 true로
            cloudMove(d,s);
            isCloud();
            makeCloud();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += map[i][j];
            }
        }
        System.out.println(ans);
    }

    private static void cloudMove (int d, int s) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            Node node = queue.poll(); // 구름 사라짐
            // 순환배열!
                int nr = (node.r + (deltas[d][0] * (s % N)) + N) % N;
                int nc = (node.c + (deltas[d][1] * (s % N)) + N) % N;
                map[nr][nc]++; // 구름 이동하고 해당 위치에 물 1 증가
                queue.offer(new Node(nr,nc)); // 새 구름 위치 추가
                visited[nr][nc] = true; // 구름 사라짐
        }
    }
    // 물복사버그
    private static void isCloud () {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 1; d < 8; d+=2) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] > 0) {
                    map[node.r][node.c]++;
                }
            }
        }
    }

    private static void makeCloud () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] < 2) continue;
                queue.offer(new Node(i,j)); // 구름 만들기
                map[i][j] -= 2;
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
