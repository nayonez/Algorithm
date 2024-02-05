import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static boolean graph[][];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수 = 배열 크기
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()) - 1; // 탐색 시작할 정점의 번호
        graph = new boolean[N][N];
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
                graph[u][v] = graph[v][u] = true;
        }
        dfs(V);
        sb.append("\n");
        visited = new boolean[N]; // bfs로 넘어가기 전 visited 초기화
        bfs(V);
        System.out.println(sb);
    }
    // 깊이 우선 탐색 = 스택 또는 재귀
    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + 1).append(" ");
        // 자식노드 순회! 인접한 노드 = i = 자식임
        for (int i = 0; i < N; i++) {
            if (visited[i]==false && graph[start][i]==true) {
                dfs(i);
            }
        }
    }
    // 너비 우선 탐색 = 큐!
    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        sb.append(start + 1).append(" ");

        while (!queue.isEmpty()) {
            
            int first = queue.poll(); // 큐의 첫번째 원소 first에 넣으면서 뺌
            
            for (int i = 0; i < N; i++) {
                if (visited[i] == false && graph[first][i] == true) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i+1).append(" ");
                }
            }
        }
    }
}
