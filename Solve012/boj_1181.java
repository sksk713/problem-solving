package Solve012;

import java.util.*;
import java.io.*;

public class boj_1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static ArrayList<String> in;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        in = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (in.contains(input))
                continue;
            in.add(input);
        }
        in.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });
        for (String val : in) {
            System.out.println(val);
        }
    }
}
