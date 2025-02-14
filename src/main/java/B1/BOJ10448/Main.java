package B1.BOJ10448;
// 유레카 이론
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 유레카 이론
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> eurekaList = new ArrayList<Integer>();
        for(int i=1; i<=45; i++){
            eurekaList.add(i*(i+1)/2);
        }
        boolean[] array = new boolean[N];
        for(int x=0; x<N; x++) {
            int number = arr[x];
            for (int i = 0; i <= 44; i++) {
                for (int j = 0; j <= 44; j++) {
                    for (int k = 0; k <= 44; k++) {
                        if (eurekaList.get(i) + eurekaList.get(j) + eurekaList.get(k) == arr[x]) {
                            array[x] = true;
                        }
                    }
                }
            }
        }
        for(int i=0; i<array.length; i++){
            if (array[i] == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
