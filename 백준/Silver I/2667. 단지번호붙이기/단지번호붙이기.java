import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count, N;
    static ArrayList<Integer> list;
    static char[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c]=='0' || visited[r][c]) continue;
                list.add(bfs(r,c));
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int l : list) {
            sb.append(l).append("\n");
        }
        System.out.println(sb);
    }
    
    private static int bfs (int r, int c) {
        count = 0;
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{r,c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            count++;
            Integer[] temp = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = temp[0] + deltas[d][0];
                int nc = temp[1] + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc]=='0' || visited[nr][nc]) continue;
                queue.offer(new Integer[] {nr,nc});
                visited[nr][nc] = true;
            }
        }
        return count;
    }
}
