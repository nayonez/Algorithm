import java.util.*;
class Solution {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] i : fares) {
            int u = i[0] - 1;
            int v = i[1] - 1;
            int weight = i[2];
            list.get(u).add(new Node(v, weight));
            list.get(v).add(new Node(u, weight));
        }
        int answer = INF;
        int[] arrS = dijkstra(n, s - 1);
        int[] arrA = dijkstra(n, a - 1);
        int[] arrB = dijkstra(n, b - 1);
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, arrS[i] + arrA[i] + arrB[i]);
        }
    
        return answer;
    }
    private static int[] dijkstra (int N, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.v]) continue;
            visited[node.v] = true;
            
            for (Node n : list.get(node.v)) {
                if (dist[n.v] > dist[node.v] + n.weight) {
                    dist[n.v] = dist[node.v] + n.weight;
                    pq.offer(new Node(n.v, dist[n.v]));
                }
            }
        } return dist;
    }
    private static class Node implements Comparable<Node> {
        int v, weight;
        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}