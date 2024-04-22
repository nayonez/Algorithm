import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17244 - 아맞다우산
public class Main {
    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int M, N, walk, items;
    static char[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로길이 = 열
        M = Integer.parseInt(st.nextToken()); // 세로길이 = 행
        map = new char[M][N];

        int r = 0;
        int c = 0;
        walk = 0;
        char item = 'a'; // a부터 ~ 최대 5개니까 e까지 item X를 바꿈
        
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                // 시작 좌표 저장
                if (s.charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
                else if (s.charAt(j) == 'X') { // 챙겨야하는 물건일경우, 구분하기위해
                    map[i][j] = item;
                    item++;
                }
            }
        }
        
        // 입력 다 받고 item의 총 개수를 알아야해서
        items = item - 'a';
        visited = new boolean[1 << items][M][N];
        System.out.println(bfs(r,c));
    }
    private static int bfs(int r, int c) {
        int time = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r,c,0)); // 처음 시작에선 물건 0개
        visited[0][r][c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (map[node.r][node.c] == 'E' && node.count == (1<<items) -1) return time;
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    int ncount = node.count;
                    if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                    if (visited[ncount][nr][nc]) continue;
                    if (map[nr][nc] == '#') continue;
                    if ('a' <= map[nr][nc] && map[nr][nc] <= 'e') { // 챙겨야하는 아이템을 만났다면..
                        ncount = ncount | (1 << map[nr][nc] - 'a'); // 물건 추가 5
                    }
                    queue.offer(new Node(nr,nc,ncount));
                    visited[ncount][nr][nc] = true;
                }
            }
            time++;
        }
        return time;
    }
    private static class Node {
        int r, c, count;
        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}
