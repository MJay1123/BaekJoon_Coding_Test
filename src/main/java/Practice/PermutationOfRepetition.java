package Practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PermutationOfRepetition {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;
        List<Integer> list = new ArrayList<>();
        permutationOfRepetition(arr, 0, r, list);
        System.out.println(result);
        System.out.println(result.size());
    }

    public static void permutationOfRepetition(int[] arr, int depth, int r, List<Integer> list){
        if(depth == r){
            List<Integer> ls = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                ls.add(list.get(i));
            }
            result.add(ls);
            return;
        }
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
            permutationOfRepetition(arr, depth+1, r, list);
            list.remove(list.size()-1);
        }
    }
}
