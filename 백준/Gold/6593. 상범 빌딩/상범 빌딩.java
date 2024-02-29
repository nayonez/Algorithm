import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/6593 - 상범 빌딩
public class Main {
    static Queue<Node> queue;
    static int L, R, C, minute;
    static char[][][] map;
    static boolean[][][] visited;
    static int[][] deltas = {{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},{1,0,0},{-1,0,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // 1~30 상범빌딩의 층 수
            R = Integer.parseInt(st.nextToken()); // 1~30 상범빌딩 한 층의 행
            C = Integer.parseInt(st.nextToken()); // 1~30 상범빌딩의 한 층의 열
            if (L==0 && R==0 && C==0) break;
            queue = new ArrayDeque<>();
            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            minute = 0;
                for (int h = 0; h < L; h++) {
                    for (int i = 0; i < R; i++) {
                        String s = br.readLine();
                        for (int j = 0; j < C; j++) {
                            map[h][i][j] = s.charAt(j);
                            if (map[h][i][j] == 'S') {
                                queue.offer(new Node(h, i, j));
                                visited[h][i][j] = true;
                            }
                        }
                    }
                    br.readLine();
                }
                if (bfs()==0) {
                    System.out.println("Trapped!");
                } else {
                    System.out.println("Escaped in " + minute + " minute(s).");
                }
        }
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // size는 한 뎁스
                Node node = queue.poll();
                for (int d = 0; d < 6; d++) {
                    int nh = node.h + deltas[d][0];
                    int nr = node.r + deltas[d][1];
                    int nc = node.c + deltas[d][2];
                    if (nh < 0 || nh >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (visited[nh][nr][nc]) continue;
                    if (map[nh][nr][nc] == '#') continue;
                    if (map[nh][nr][nc] == 'E') return minute++;
                    queue.offer(new Node(nh,nr,nc));
                    visited[nh][nr][nc] = true;
                }
            } minute++;
        }
        return 0;
    }

    private static class Node {
        int h, r, c;
        public Node(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
}
