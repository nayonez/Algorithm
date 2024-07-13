import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] originalArr = new int[9];
        int[] sortArr = new int[9];
        for (int i = 0; i < 9; i++) {
            sortArr[i] = originalArr[i] = Integer.parseInt(br.readLine());                        
        }
        Arrays.sort(sortArr);
        int max = sortArr[8];
        for (int i = 0; i < 9; i++) {
            if (originalArr[i] == max) {
                max = i+1;
                break;
            }
        }
        System.out.println(sortArr[8]);
        System.out.println(max);
    }
}