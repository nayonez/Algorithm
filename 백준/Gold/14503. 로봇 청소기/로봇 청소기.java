import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14503 - 로봇 청소기
public class Main {
    static int[][] map;
    static int N,M,count,d;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}}; // 상우하좌 북동남서
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        count = 0;
        map = new int[N][M];
        st = new StringTokenizer(br.readLine()); // 처음 로봇 청소기가 있는 칸의 좌표r c, 처음에 로봇 청소기가 바라보는 방향
        int r = Integer.parseInt(st.nextToken()); // 처음 로봇 청소기 행
        int c = Integer.parseInt(st.nextToken()); // 처음 로봇 청소기 열
        d = Integer.parseInt(st.nextToken()); // 처음에 로봇 청소기 방향 0상, 1우, 2하, 3좌

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 1이면 벽, 0이면 청소안함
            }
        }

        clean(r,c); //처음 로봇 청소기가 있는 칸의 좌표r c
        System.out.println(count);
    }

    private static void clean(int r, int c) { // 청소완료한 칸은 -1로 변경
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r,c));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
          
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다. 0 -> -1로 변경
            if (map[node.r][node.c] == 0) {
                map[node.r][node.c] = -1;
                count++; // 청소하는 칸마다 증가
            }
            // 2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!empty(node.r, node.c)) {
                int backnr = node.r + deltas[(d+2)%4][0];
                int backnc = node.c + deltas[(d+2)%4][1];

                if (map[backnr][backnc] == 1) {
                    return;
                } else {
                    queue.offer(new Node(backnr,backnc));
                }
            } else { 
                while (true) {

                    d = (d + 3) % 4;
                    int frontnr = node.r + deltas[d][0];
                    int frontnc = node.c + deltas[d][1];
                    if (map[frontnr][frontnc] == 0) {
                        queue.offer(new Node(frontnr, frontnc));
                        break;
                    }
                }
            }
        }
    }

    private static boolean empty(int r, int c){
        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(map[nr][nc] == 0) return true; 
        } return false;
    }
    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
