package Silver.S3.BOJ1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            String[] strArr = str.split("");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        int min = Math.min(n,m);
        for(int i=min; i>=1; i--){
            if(checkSquare(i, arr)){
                System.out.println(i*i);
                break;
            }
        }
    }

    public static boolean checkSquare(int n, int[][] arr){
        if(n > arr.length || n > arr[0].length){
            return false;
        }
        for(int i=0; i+n<=arr.length; i++){
            for(int j=0; j+n<=arr[0].length; j++){
                if(arr[i][j] == arr[i][j+n-1] && arr[i][j] == arr[i+n-1][j] && arr[i][j] == arr[i+n-1][j+n-1]){
                    return true;
                }
            }
        }
        return false;
    }
}
