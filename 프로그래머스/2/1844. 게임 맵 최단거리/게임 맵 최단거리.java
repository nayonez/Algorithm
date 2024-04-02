import java.util.*;
class Solution {
    
    static int n, m, count;
    static boolean[][] visited;
    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int solution(int[][] maps) {
        n = maps.length; // maps의 행
        m = maps[0].length; // maps의 열
        
        visited = new boolean[n][m];
        
        count = 0;
        
        return bfs(0, 0, maps);
    }
    private static int bfs(int r, int c, int[][] maps) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{r,c});
        visited[r][c] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++; // depth 체크
            for (int i = 0; i < size; i++) {
                Integer[] temp = queue.poll(); // 지금 확인할 거
            
                if (temp[0] == n-1 && temp[1] == m-1) return count; // 이 while문 빠져나가기
                for (int d = 0; d < 4; d++) {
                    int nr = temp[0] + deltas[d][0];
                    int nc = temp[1] + deltas[d][1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (visited[nr][nc]) continue;
                    if (maps[nr][nc] == 0) continue; // 0 이면 벽이므로 못감 = 탐색x
                    queue.offer(new Integer[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        } // 큐가 그냥 비어서 끝났을 때.. 보통은 저 break문 만나서 끝날텐데..
        count = -1;
        return count;
    } 
}