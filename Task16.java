package roundThree;

import java.io.*;

public class Task16 {
    private static int answer;

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            int N = Integer.parseInt(fileReader.readLine());
            recursion(1,N);
            answer++;
            fileWriter.write(String.valueOf(answer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recursion (int level, int N) {

        for (int i = level; i < (N-i); i++) {
            int number = N - i;
            int nextLevel =  i + 1;
            recursion(nextLevel,number);
            answer++;
        }

    }
}
