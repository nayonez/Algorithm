import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int n = Integer.parseInt(a);
        int result = 0;

        for(int i = 1; i <= 9; i++) {
            result = n * i;
            System.out.println(a + " * " + i + " = " + result);
        }
    }
}