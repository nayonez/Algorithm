import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/14502 - 연구소
public class Main {
    static int N, M, maxSafe;
    static int[][] map, copyMap;
    static List<Node> list;
    static Node[] tgt; // 내가 벽 세울 3군데 행열 좌표
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 지도 세로의 크기 = 행
        M = Integer.parseInt(st.nextToken()); // 지도 가로의 크기 = 열
        list = new ArrayList<>();
        maxSafe = Integer.MIN_VALUE;
        map = new int[N][M];
        copyMap = new int[N][M];
        tgt = new Node[3];
        boolean[][] visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()); // 0빈칸, 1벽, 2바이러스
                if (map[r][c]==0) {
                    list.add(new Node(r,c));
                }
            }
        }
        dfs(0,0);
        System.out.println(maxSafe);
    }

    // 안전영역의 개수 탐색 후 리턴
    private static int safe() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) count++;
            }
        } return count;
    }
    // 복사한 맵에 바이러스 퍼뜨리기
    private static void virusbfs() {
        Queue<Node> virusQ = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2) {
                    virusQ.offer(new Node(i,j));
                    visited[i][j] = true;
                }
            }
        }
        while (!virusQ.isEmpty()) {
            Node node = virusQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (copyMap[nr][nc] == 0) {
                    copyMap[nr][nc] = 2; // 바이러스 감염
                    virusQ.offer(new Node(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    // 조합 (3개의 벽을 세워야함) 3개 벽의 각각 행,열 위치!
    private static void dfs(int depth, int start) {

        // 반복 중단할 조건
        if (depth == 3) { // 벽 3개 구했을 때마다 bfs로 안전영역 개수 구하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < tgt.length; i++) {
                copyMap[tgt[i].r][tgt[i].c] = 1;
            } // tgt 빼서 그 위치에 1로 벽 세워줘야함
            virusbfs();
            maxSafe = Math.max(maxSafe, safe());
            return;
        }

        for (int i = start; i < list.size(); i++) { //list에는 0인 곳만 저장되어있음. 벽을 세울 수 있는 곳
            tgt[depth] = list.get(i);
            dfs(depth+1, i+1);
        }
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
