import java.io.*;
import java.util.*;

public class Main {
    static int tc, n, m;
    static Queue<Integer> index, priority;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            // 문서의 개수, 찾고 싶은 문서 인덱스
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            // 인덱스 저장
            index = new LinkedList<>();
            // 중요도 저장
            priority = new LinkedList<>();
            // 문서 개수만큼의 중요도
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                index.offer(j); // 인덱스
                priority.offer(Integer.parseInt(st2.nextToken())); // 중요도
            }
            print();

        }
        System.out.println(sb);
    }
    static void print() {
        int count = 1;
        while (!priority.isEmpty()) {
            // 중요도 큐에서 가장 큰 중요도=가장 먼저 출력될 것. 계속 변경됨
            int maxPriority = Collections.max(priority);
            // 현재 중요도
            int currentPriority = priority.poll();
            // 현재 인덱스
            int currentIndex = index.poll();

            // 현재 중요도가 최대 중요도가 되었을때
            if (currentPriority == maxPriority) {
                if (currentIndex == m) {
                    sb.append(count).append("\n");
                    break; // 원하는 m번 인덱스의 중요도가 최고 중요도가 되었을때 출력을 했으니까
                }
                count++;
            }
            else {
                // 아직 최우선순위가 아닐 경우, 뒤에 넣어준다
                priority.offer(currentPriority);
                index.offer(currentIndex);
            }
        }
    }
}
