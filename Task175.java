package roundThree;

import java.io.*;

public class Task175 {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            String strTime = fileReader.readLine();
            String[] hoursAndMinutes = strTime.split(":");
            int timeInSeconds = Integer.parseInt((hoursAndMinutes[0])) * 60 + Integer.parseInt(hoursAndMinutes[1]);

            int answer = 0;
            if (timeInSeconds >= 0 && timeInSeconds <= 599) {
                answer = 20 * 60 - timeInSeconds;
            } else if (timeInSeconds > 599 && timeInSeconds <= 1019) {
                answer = 24 * 60 - timeInSeconds;
            } else if (timeInSeconds > 1019 && timeInSeconds <= 1199) {
                answer = (24 + 5) * 60 - timeInSeconds;
            } else if (timeInSeconds > 1199 && timeInSeconds <= 1440) {
                answer = (24 + 10) * 60 - timeInSeconds;
            }
            fileWriter.write(String.valueOf(answer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
