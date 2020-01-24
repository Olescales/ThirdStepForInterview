package roundThree;

import java.io.*;
import java.util.ArrayList;
//E:\олег\
public class Task57Second {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            String line = fileReader.readLine();
            String[] taskData = line.split("\\s+");
            int numberOfPigs = Integer.parseInt(taskData[0]);
            int cableCostPerMetre = Integer.parseInt(taskData[1]);
            long moneyAvailable = Long.parseLong(taskData[2]);
            ArrayList<Integer[]> coordinates = new ArrayList<>();
            while (fileReader.ready()) {
                String line1 = fileReader.readLine();
                String [] stringPigCoordinates = line1.split("\\s+");
                Integer[] pigCoordinates = new Integer[2];
                pigCoordinates[0] = Integer.parseInt(stringPigCoordinates[0]);
                pigCoordinates[1] = Integer.parseInt(stringPigCoordinates[1]);
                coordinates.add(pigCoordinates);
            }
            Integer[] inetSource = coordinates.remove(coordinates.size()-1);
            String answerOutput = "NO";
            double needCableForInet = 0;
            for (int i = 0; i < coordinates.size(); i++) {
                double distBetweenSourceAndPig = Math.hypot(coordinates.get(i)[0] - inetSource[0],coordinates.get(i)[1] - inetSource[1]);
                needCableForInet += distBetweenSourceAndPig;
                for (int j = 0; j < coordinates.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    int xI = coordinates.get(i)[1];
                    int yI = coordinates.get(i)[0];
                    int xLast = coordinates.get(j)[1];
                    int yLast = coordinates.get(j)[0];
                    double hipot = Math.hypot(yI - yLast,xI - xLast);
                    needCableForInet += hipot;

                }
                if (needCableForInet * cableCostPerMetre <= moneyAvailable) {
                    answerOutput = "YES";
                    break;
                } else {
                    needCableForInet = 0;
                }
            }

            fileWriter.write(answerOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
