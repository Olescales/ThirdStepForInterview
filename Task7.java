package roundThree;

import java.io.*;
import java.util.TreeSet;

public class Task7 {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            String line = fileReader.readLine();
            String[] strNumbers = line.split("\\s+");
            TreeSet<String> numberStorage = new TreeSet<>();
            int maxStringLengthInArray = 0;
            for (String number : strNumbers) {
                if (number.length() > maxStringLengthInArray) {
                    maxStringLengthInArray = number.length();
                }
            }
            int differenceInLength = 0;
            for (String number : strNumbers) {
                if (number.length() < maxStringLengthInArray) {
                    differenceInLength = maxStringLengthInArray - number.length();
                    StringBuilder sb = new StringBuilder(number);
                    for (int i = 0; i < differenceInLength; i++) {
                        sb.insert(0, "0");
                    }
                    numberStorage.add(sb.toString());
                } else {
                    numberStorage.add(number);
                }
            }

            fileWriter.write(numberStorage.last().replaceAll("^0*", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
