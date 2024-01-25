import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] intArr = new int[30];
        int a = 0;

        for (int i = 0; i < 30; i++) {
            try{
                a = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {

            }
            intArr[a-1] = 1;
        }

        for (int i = 0; i < 30; i++) {
            if (intArr[i] == 0) {
                int result = i + 1;
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}
