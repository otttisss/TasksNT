package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Incorrect number of args. Usage: java Task4.java test_file");
        }

        int[] nums = fileReader(args[0]);

        if (nums != null) {
            int moves = findMinimum(nums);
            System.out.println(moves);
        }
    }

    private static int[] fileReader(String fileName) { // Метод чтения из тестового файла
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Integer> numsList = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                numsList.add(num);
            }

            int[] nums = new int[numsList.size()];
            for (int i = 0; i < numsList.size(); i++) {
                nums[i] = numsList.get(i);
            }

            return nums;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int findMinimum(int[] nums) {

    }
}
