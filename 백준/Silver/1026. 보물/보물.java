import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 숫자의 개수
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>(); // 순서 고정
        // A[0] * B[0] + ... + A[마지막인덱스]*B[마지막인덱스] = 최솟값
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(listA); // 오름차순
        Collections.sort(listB, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += listA.get(i) * listB.get(i);
        }
        System.out.println(sum);
    }
}
