import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 세로 길이 = 행
        n = Integer.parseInt(st.nextToken()); // 가로 길이 = 열
        int k = Integer.parseInt(st.nextToken()); // 직사각형 개수
        map = new boolean[m][n];
        visited = new boolean[m][n];
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {       // 입력받은 직사각형을 어떻게 넣어야할지를 모루겠다..
            st = new StringTokenizer(br.readLine()); // 넣고
            int c1 = Integer.parseInt(st.nextToken()); // 열
            int r1 = Integer.parseInt(st.nextToken()); // 행
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            for (int r = r1; r < r2; r++) {
                for (int c = c1; c < c2; c++) {
                    map[r][c] = true;

                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (map[i][j]) continue;
                list.add(bfs(i,j));
            }
        }
        sb.append(list.size()).append("\n");
        Collections.sort(list);

        for (int l : list) {
            sb.append(l).append(" ");
        }
        System.out.println(sb);

    }

    public static int bfs(int r, int c) {
        int count = 0;
        int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r,c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            count++;
            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nr = arr[0] + deltas[d][0];
                int nc = arr[1] + deltas[d][1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (map[nr][nc]) continue;
                if (visited[nr][nc]) continue;
                queue.offer(new int[] {nr,nc});
                visited[nr][nc] = true;
            }
        }
        return count;
    }
}
