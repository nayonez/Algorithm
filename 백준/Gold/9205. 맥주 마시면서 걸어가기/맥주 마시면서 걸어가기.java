import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static boolean[] visited;
    static int n;
    static boolean flag;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        for (int i = 0; i < T; i++) {
            int beers = 1000; // 50미터에 한병씩
            flag = false; // 상태 sad
            n = Integer.parseInt(br.readLine()); // 맥주 파는 편의점의 개수
            map = new int[n+2][2]; // 행->집좌표+편의점n+페스티벌좌표, 열->x,y좌표
            visited = new boolean[n+2]; // 노드 개수만큼만 체크

            for (int j = 0; j < n+2; j++) { // 첫행이 집, 마지막행이 페스티벌장소
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[j][0] = Integer.parseInt(st.nextToken());
                map[j][1] = Integer.parseInt(st.nextToken());
            }
            bfs(map[0][0], map[0][1]);
        }
        System.out.println(sb);
    }
    private static void bfs(int r, int c) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c));
        visited[0] = true; // 출발지점
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.r==map[n+1][0] && node.c==map[n+1][1]) { // 페스티벌장에 도착했다면
                flag = true;
                break;
            }
            for (int i = 1; i < n+2; i++) {
                if (visited[i]) continue;
                if (Math.abs(node.r-map[i][0]) + Math.abs(node.c-map[i][1]) <= 1000) {
                    queue.offer(new Node(map[i][0], map[i][1]));
                    visited[i] = true;
                }
            }

        }
        if (flag) sb.append("happy").append("\n");
        else sb.append("sad").append("\n");
    }
    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
