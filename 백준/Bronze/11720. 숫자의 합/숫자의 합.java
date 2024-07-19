import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 입력에 공백이 없기 때문에 charArr로 받음
        char[] charArr = new char[n];
        charArr = br.readLine().toCharArray();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // char는 숫자연산이 안되니까 - '0' 연산해서 숫자로 만들어주기
            if (charArr[i] - '0' > 0) {
                sum += charArr[i] - '0';
            }
        }
        System.out.println(sum);
    }
}
