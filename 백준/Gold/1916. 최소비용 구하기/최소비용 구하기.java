import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1916 - 최소비용 구하기
public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static final int INF = Integer.MAX_VALUE;
    static int N;
    private static void solution() throws Exception {
        // N개의 도시 -> 정점의 수가 N개
        // 도시 간 이동하는 버스의 수가 M개 -> 간선의 수가 M개
        // 특정 시작점부터 특정 도착점까지의 최소 비용
        // 가중치 값 범위 : 0 ~ 100,000 -> 양의 가중치만 존재
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수
        // graph 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        // 그래프 정보를 다 저장해야될땐 리스트로 하는게 좋음
        // 입력 정보 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1; //idx 처리
            int v = Integer.parseInt(st.nextToken()) - 1; //idx 처리
            int w = Integer.parseInt(st.nextToken()); // 가중치는 그대로
            // u 번째를 넣으려면 u번째가 어딘지 모르니 위에서 다 일단 초기화 해주는것 (graph 초기화부분)
            graph.get(u).add(new Node(v, w)); // u에서 v까지의 가중치가 w
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 시작 도시번호
        int start = Integer.parseInt(st.nextToken()) - 1; // idx 처리
        // 도착 도시번호
        int end = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra (int start, int end) {
        // 아래 노드클래스에 comparable이랑 오버라이드 안해주고 이 한줄 이렇게 써줘도 정렬 가중치 오름차순으로 잘 됨(선택)
//        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        // 1. dist 배열 초기화 (시작 정점은 0, 나머지는 INF)
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            // 도착점에 도달하면 최소비용 return
            if (node.v == end) return dist[end];
            if (visited[node.v]) continue;
            visited[node.v] = true;
            // 현재 탐색 중인 node에서 갈 수 있는 애들 중 방문하지 않은 노드들의 가중치 확인
            for (Node next : graph.get(node.v)) {
                if (visited[next.v]) continue;
                // 더 적은 값으로 갱신
                if (dist[next.v] > dist[node.v] + next.weight) {
                    dist[next.v] = dist[node.v] + next.weight;
                    // greedy한 성질
                    // 새로 갱신된 dist 값을 넘겨줌
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return INF;
    }

    // pq에 컴퍼레이터 해도 되는데 그냥 객체에다가 편하게 오버라이드 함
    private static class Node implements Comparable<Node> {
        int v, weight;
        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        // 가중치 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
