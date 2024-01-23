import java.io.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[9];
        int max = Integer.MIN_VALUE;
        int result = 0;

        for(int i = 0; i < 9; i++ ) {
            numbers[i] = Integer.parseInt(br.readLine());
            if(max < numbers[i]) {
                max = numbers[i];
                result = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(result);
    }
}