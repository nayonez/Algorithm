import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1194 - 달이 차오른다, 가자.
public class Main {
    static boolean[][][] visited; // 층(키 별로), 행, 열
    static char[][] map;
    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int N, M;


    public static void main(String[] args) throws Exception {
        // 11f    9e      8d       c4       b 2     a  1
        // 1011   1001    1000     0100     0010    0001
        // a|b3   a&b0
        // 0011   0000
        // 열쇠 a b c d e f - > char temp - 'a' 하면 각각 a=0 b=1 c=2 d=3 e=4 f=5 의 값으로 구분 가능
        // 문   A B C D E F - > char temp - 'A' 하면 각각 A=0 B=1 C=2 D=3 E=4 F=5 의 값으로 구분 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        visited = new boolean[1<<6][N][M];
        int r = 0;
        int c = 0;
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                // s.charAt == 0 일때 탐색을 시작! 0 일 때 좌표를 저장해놓기
                if (s.charAt(j) == '0') {
                    r = i;
                    c = j;
                }
            }
        }
        System.out.println(bfs(r,c));

    }
    private static int bfs(int r, int c) {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c, 0)); // 처음엔 키가 없음
        visited[0][r][c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (map[node.r][node.c] == '1') return count;
                // 사방탐색
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    int nk = node.key; // 지금은 nk는 자기 자신(나중에 key 획득하면 변경)
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[nk][nr][nc]) continue; // 방문했으면 패스
                    if (map[nr][nc] == '#') continue; // #은 벽
                    if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') { // (a~f 범위 안의)키 라면
                        // 현재 키에 or 연산으로 (키는 하나만 있어도 있는거니까) 1을 0~5 중에 해당값을 비트연산
                        nk = node.key | 1 << (map[nr][nc] - 'a');
                    }
                    else if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
                        // 문에 해당하는 키가 있는지 확인 후, 키 있으면 큐에 넣어주기!
                        // 현재 가지고 있는 키와 and연산해서 둘다 1 값이어야만 1 나오게 1 이어야 큐에 넣고 ..
                        if ((node.key & (1 << (map[nr][nc] - 'A'))) == 0) {
                            // 현재 갖고있는 키 and연산 map - 'A'문의 값 이 0이면 해당X
                            continue;
                        }
                    }
                    // 위의 모든 조건문에 안걸린다면
                    queue.offer(new Node(nr,nc,nk));
                    visited[nk][nr][nc] = true;
                }
            }
            count++;
        }
        return -1; // while문이 중간에 break로 빠져나오지 않고 여기서 끝났다면 미로 탈출 못한거
        
    }

    private static class Node {
        int r;
        int c;
        int key; // 현재 어떤 키들을 가지고 있는지!
        public Node(int r, int c, int key) {
            this.r = r;
            this.c = c;
            this.key = key;
        }
    }

}
