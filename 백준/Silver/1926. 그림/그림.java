import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 사방탐색

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken()); // 세로길이 = 행 1부터
        M = Integer.parseInt(st.nextToken()); // 가로길이 = 열 1부터
        map = new boolean[N][M]; // 1부터
        visited = new boolean[N][M]; // 1부터
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp==1)
                    map[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) // 방문했던곳이면 패스
                    continue;
                if(!map[i][j]) // 맵의 정보가 false면
                    continue;
                list.add(bfs(i, j)); // 실행될때마다 하나씩 생성됨
            }
        }

        if (!list.isEmpty()) {
            System.out.println(list.size());
            System.out.println(Collections.max(list));
        } else {
            System.out.println(0);
            System.out.println(0);
        }
    }
    // 큐
    private static int bfs(int r, int c) {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c));
        visited[r][c] = true;

        // 사방탐색 시작
        while (!queue.isEmpty()) {

            Node node = queue.poll();// 빼야돼
            count++;
            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                // 범위체크가 가장 우선
                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc]) {
                    queue.offer(new Node(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        return count;
    }

    private static class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
