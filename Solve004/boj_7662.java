package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static TreeMap<Integer, Integer> tr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            tr = new TreeMap<>();
            for (int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                String inst = st.nextToken();
                String num = st.nextToken();
                if (inst.equals("I")) {
                    tr.put(Integer.parseInt(num), tr.getOrDefault(Integer.parseInt(num), 0) + 1);
                }
                else {
                    if (tr.isEmpty()) {
                       continue;
                    }
                    if (Integer.parseInt(num) == 1) {
                        if (tr.get(tr.lastKey()) == 1) {
                            tr.remove(tr.lastKey());
                        }
                        else {
                            tr.put(tr.lastKey(), tr.get(tr.lastKey()) - 1);
                        }
                    }
                    else {
                        if (tr.get(tr.firstKey()) == 1){
                            tr.remove(tr.firstKey());
                        }
                        else
                            tr.put(tr.firstKey(), tr.get(tr.firstKey()) - 1);

                    }
                }

            }
            if (tr.isEmpty()) {
                System.out.println("EMPTY");
            }
            else
                System.out.println(tr.lastKey() + " " + tr.firstKey());

        }

    }
}
