import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 상단 대각선 좌 -> 우  ->  하단 대각선 우 -> 좌 순서!
    static int[][] deltas = {{1, -2},{2, -1},{2, 1},{1, 2},{-1, 2},{-2, 1},{-2, -1},{-1, -2}};
    static int moveR, moveC, length;
    static int count;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            length = Integer.parseInt(br.readLine()); // 변의 길이, 정사각형
            visited= new boolean[length][length];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            moveR = Integer.parseInt(st.nextToken());
            moveC = Integer.parseInt(st.nextToken());
            bfs(r,c);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r,c));
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.r == moveR && node.c == moveC) {
                    return;
                }
                for (int d = 0; d < 8; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    if (nr < 0 || nr >= length || nc < 0 || nc >= length)
                        continue;
                    if (visited[nr][nc])
                        continue;
                    queue.offer(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            count++;
        }
    }

    private static class Node{
        int c, r;
        public Node(int r, int c) {
            this.c = c;
            this.r = r;
        }
    }
}
