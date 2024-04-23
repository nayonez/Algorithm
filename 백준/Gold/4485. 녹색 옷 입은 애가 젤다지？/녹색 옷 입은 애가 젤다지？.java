import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 1;
        int a = 1;
        while (true) {
            N = Integer.parseInt(br.readLine()); // 동굴의 크기 0들어오면 종료
            if (N == 0) break;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem ").append(a++).append(": ").append(dijkstra()).append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int[][] dist = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = map[0][0];

        pq.offer(new Node(0, 0, dist[0][0]));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.r][node.c]) continue;
            else {
                visited[node.r][node.c] = true;
            }
            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (dist[nr][nc] > map[nr][nc] + node.weight) {
                    dist[nr][nc] = map[nr][nc] + node.weight; // node.weight는 누적된 가중치 값
                    pq.offer(new Node(nr,nc,dist[nr][nc]));
                }
            }
        }
        return dist[N-1][N-1];
    }
    private static class Node implements Comparable<Node> {
        int r, c, weight;
        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 오름차순
        }
    }

}
