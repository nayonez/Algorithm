import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int bar = 64;
        int[] arr = {64,32,16,8,4,2,1};
        int sum = 0; // 막대 길이의 합
        int count = 0; // 막대 개수
        for (int i = 0; i < arr.length; i++) { //arr 길이 체크
            if (arr[i] > X) { // 구하고자 하는 Xcm보다 길다면
                continue;
            }
            if (sum + arr[i] <= X) { // 현재 막대길이의 합+arr[i]가 구할 X보다 작거나 같으면, 이 길이 포함
                count++;
                sum += arr[i];
            }
            if (sum == X) {
                break;
            }
        }
        System.out.println(count);
    }
}
