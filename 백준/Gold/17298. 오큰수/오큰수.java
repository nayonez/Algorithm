import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N]; // arr 배열에는 들어온 값 저장
        Stack<Integer> stack = new Stack<>(); // stack에는 배열의 인덱스 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //arr 개수만큼 돌면서 진행
        for (int i = 0; i < N; i++) {
            // stack에 데이터가 없고 && 현재 arr[i]보다 stack제일위에 값(배열의 인덱스)이 크거나 같을때 반복 중단
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                // 그런 경우가 아니라면 .. 스택의 가장 위의 값 빼고 idx를 저장
                int idx = stack.pop();
                arr[idx] = arr[i]; // 오큰수로 바꿔서 저장해줌
            }
            // stack에 i인덱스를 추가
            stack.push(i);
        }
        // 스택에 값이 남아있다면 오큰수가 없다는 뜻
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
