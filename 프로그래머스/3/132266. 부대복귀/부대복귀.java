import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            int a = r[0] - 1;
            int b = r[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dijkstra(n, destination-1);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            if (dist[sources[i] - 1] == INF) answer[i] = -1;
            else answer[i] = dist[sources[i] - 1];
        }
        return answer;
    }
    private static void dijkstra (int n, int destination) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist = new int[n];
        Arrays.fill(dist, INF);
        queue.offer(destination);
        dist[destination] = 0; // 시작점이니까
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int a : graph.get(node)) {
                if (dist[a] > dist[node] + 1) {
                    dist[a] = dist[node] + 1;
                    queue.offer(a);
                }
                
            }
            
        }
    }
}