package BOJ3040;
// 백설 공주와 일곱 난쟁이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for(int i=0; i<9; i++){
            sum += arr[i];
        }

        for(int i=0; i<8; i++){
            for(int j = i+1; j<9; j++){
                int temp = arr[i] + arr[j];
                if((sum - temp) == 100){
                    arr[i] = 1000;
                    arr[j] = 1000;
                }
            }
        }

        for(int i=0; i<9; i++){
            if(arr[i] != 1000){
                System.out.println(arr[i]);
            }
        }
    }
}
