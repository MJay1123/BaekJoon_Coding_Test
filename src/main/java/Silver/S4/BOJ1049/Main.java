package Silver.S4.BOJ1049;
// 기타줄
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 필요한 기타 줄의 수
        int M = Integer.parseInt(st.nextToken());       // 기타 줄 브랜드 갯수

        int[][] arr = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int packageNumber = N / 6;
        int eachNumber = N % 6;

        int packagePrice = arr[0][0];
        int eachPrice = arr[0][1];
        for(int i=0; i<M; i++){
            packagePrice = Math.min(packagePrice, arr[i][0]);
            eachPrice = Math.min(eachPrice, arr[i][1]);
        }
        int price = 0;
        if(packagePrice <= eachPrice * 6){
            price += packagePrice * packageNumber;
            if(packagePrice <= eachPrice * eachNumber){
                price += packagePrice;
            } else {
                price += eachPrice * eachNumber;
            }
        } else {
            price = eachPrice * N;
        }
        System.out.println(price);
    }
}
