package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, ArrayList<String>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String x = st.nextToken();
            String y = st.nextToken();
            String z = st.nextToken();

            ArrayList<String> node = new ArrayList<>();
            node.add(y);
            node.add(z);

            map.put(x, node);
        }
        preorder("A");
        System.out.println();
        inorder("A");
        System.out.println();
        postorder("A");
    }

    static void preorder(String start) {
        if (start.equals("."))
            return;

        System.out.print(start);
        preorder(map.get(start).get(0));
        preorder(map.get(start).get(1));

    }

    static void inorder(String start) {
        if (start.equals("."))
            return;

        inorder(map.get(start).get(0));
        System.out.print(start);
        inorder(map.get(start).get(1));
    }

    static void postorder(String start) {
        if (start.equals("."))
            return;

        postorder(map.get(start).get(0));
        postorder(map.get(start).get(1));
        System.out.print(start);
    }
}
