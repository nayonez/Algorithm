import java.io.BufferedReader;
import java.io.InputStreamReader;

// 단어공부
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int maxAlpha = Integer.MIN_VALUE;
        int maxIdx = 0;
        String s = br.readLine().toUpperCase();

        int[] alphabet = new int[26]; // 들어온 한 글자 - 'A'를 하면 0부터 26까지 인덱스별로 저장 가능
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            alphabet[idx]++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            maxAlpha = Math.max(maxAlpha, alphabet[i]);
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == maxAlpha) {
                count++; // 찾은 maxAlpha 당연히 있으니까 1 될거고 .. 하나더 찾으면 2
            }
        }
        if (count >= 2) {
            System.out.println("?");
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == maxAlpha) {
                    maxIdx = i;
                    break;
                }
            }
            char ans = (char)(maxIdx+'A');
            System.out.println(ans);
        }
    }
}
