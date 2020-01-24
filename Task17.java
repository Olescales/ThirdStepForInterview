package roundThree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task17 {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("E:\\олег\\input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("E:\\олег\\output.txt"))) {

            int numberOfElements = Integer.parseInt(fileReader.readLine());

            List<Integer> dividers = new ArrayList<>();
            for (int i = 1; i <numberOfElements; i++) {
                if ((numberOfElements - 1) % i == 0) {
                    dividers.add(i);
                }
            }

            String[] rawElements = fileReader.readLine().split("\\s+");
            int [] intElements = new int[rawElements.length-1];
            for (int i = 0; i < intElements.length; i++) {
                intElements[i] = Integer.parseInt(rawElements[i]);
            }

            int [] arrayForCheck;
            int answer = 0;
            int flag;
            for (int i = 1; i < dividers.size(); i++) {
                flag = 0;
                arrayForCheck = new int[dividers.get(i)];
                for (int j = 0; j < arrayForCheck.length; j++) {
                    arrayForCheck[j] = intElements[j];
                }
                for (int k = 0; k < intElements.length; ) {
                    for (int u = 0; u < arrayForCheck.length; u++) {
                        if (arrayForCheck[u] != intElements[k]) {
                            flag = 1;
                            break;
                        }
                        k++;
                    }
                    if (flag == 1) {
                        break;
                    }
                }

                if (flag == 0) {
                    answer = arrayForCheck.length;
                    break;
                }
            }

            fileWriter.write(String.valueOf(answer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
