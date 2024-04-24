import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A = 65.. A-65 = 0, B-65 = 1, C-65 = 2, ... -> ABC=012는 3(2+1초)이다.
        //           A B C D E F G H I J K L M N O P Q R S T U V W  X  Y  Z
        int[] num = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
        String temp = br.readLine();
        int ans = 0;
        for (int i = 0; i < temp.length(); i++) {
            int alpha = temp.charAt(i) - 65;
            ans += num[alpha];
        }
        System.out.println(ans);
    }
}
