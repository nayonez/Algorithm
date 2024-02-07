import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int n, b;
    static ArrayList<ArrayList<Integer>> list;
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        sum = -1;
        n = Integer.parseInt(br.readLine()); // 전체 사람 수
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>()); // 한줄씩 크기 할당
        }
        
        int a = Integer.parseInt(st.nextToken()); // 계산원하는 사람 1
        b = Integer.parseInt(st.nextToken()); // 계산원하는 사람 2

        int m = Integer.parseInt(br.readLine()); // 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int xParent = Integer.parseInt(st.nextToken()); // child의 부모
            int yChild = Integer.parseInt(st.nextToken());
            list.get(xParent).add(yChild);
            list.get(yChild).add(xParent);
        }
        bfs(a, 0);
        System.out.println(sum);
    }

    private static void bfs (int start, int count) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp==b) {
                    sum = count;
                    return;
                }
                for (int a : list.get(temp)) {
                    if (visited[a])
                        continue;
                    queue.offer(a);
                    visited[a] = true;
                }
            }
            count++;
        } sum = -1;

    }
}
