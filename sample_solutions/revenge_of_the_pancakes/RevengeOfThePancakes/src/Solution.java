import java.io.*;

public class Solution {

    private static int count = 1;

    private static BufferedWriter bw;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/B-small-practice.in"));
//            BufferedReader br = new BufferedReader(new FileReader("src/B-large-practice.in"));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("solution.out"), "utf-8"));
            int n = Integer.parseInt(br.readLine());

            System.out.println(n);

            String line;
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                if (line != null) {
                    solve(line);
                }
            }

            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void solve(String pancakeStack) {
        char[] stack = pancakeStack.toCharArray();

        // loop through the stack comparing if elements are different.
        // we want to flip the stack when we encounter a difference in pancake
        // that way we maximize the amount of work we do per flip
        int flips = 0;
        for (int i = 0; i < stack.length - 1; i++) {
            if (stack[i] != stack[i + 1]) {
                flips++;
            }
        }

        // now lets see if we need to flip the entire stack!
        if (stack[stack.length - 1] == '-') {
            flips++;
        }

//        System.out.println("Case #" + count + ": " + flips);
        try {
            bw.write("Case #" + count + ": " + flips + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        count++;
    }
}
