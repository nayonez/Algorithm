import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String[] strArr = new String[N];
        ArrayList<Character> list;
        
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            list = new ArrayList<>();
            strArr[i] = br.readLine(); // str배열에 단어 입력받아 저장
            char[] charArr = new char[strArr[i].length()];
            // charArr에 string배열 하나씩
            for (int j = 0; j < strArr[i].length(); j++) {
                charArr[j] = strArr[i].charAt(j);
            }
            list.add(charArr[0]);

            if (strArr[i].length() == 1) {
                ans++;
                continue;
            }

            for (int j = 1; j < charArr.length; j++) {
                if (list.contains(charArr[j])) { // 일단 내가 list에 있는지 체크
                    if (charArr[j] != charArr[j-1]) { // 내가 list에 있는데 내 앞에 문자가 나랑 다르면
                        flag = false; // 그룹 단어가 아님
                        break;
                    }
                } else { // 내가 list에 없을 때
                    list.add(charArr[j]);
                }
            }

            if (flag) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
