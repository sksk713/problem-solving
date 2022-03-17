package Solve013;

import java.util.*;
import java.io.*;

public class boj_20291 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static Map<String, Integer> input = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split("\\.");
            input.put(in[1], input.getOrDefault(in[1], 0) + 1);
        }

        for (Map.Entry x : input.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}
