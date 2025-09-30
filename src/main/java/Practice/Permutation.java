package Practice;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[4];
        int r = 3;
        List<Integer> list = new ArrayList<>();
        permutation(arr, visited, 0, r, list);
        System.out.println(result);
        System.out.println(result.size());
    }

    public static void permutation(int[] arr, boolean[] visited, int depth, int r, List<Integer> list){
        if(depth == r){
            List<Integer> ls = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                ls.add(list.get(i));
            }
            result.add(ls);
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                permutation(arr, visited, depth+1, r, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
