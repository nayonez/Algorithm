import java.io.*;
import java.util.*;

public class Main {
    static int connect;
    static int N;
    static boolean[] visited;
    static boolean[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new boolean[N][N];
        visited = new boolean[N];
        connect = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u][v] = graph[v][u] = true;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                connect++;
            }
        }
        System.out.println(connect);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < N; i++) {
                if (visited[i]==false && graph[temp][i] == true) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
