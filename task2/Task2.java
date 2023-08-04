package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Incorrect number of args.Usage: java CirclePositionCalculator <circle_file> <points_file>");
            return;
        }

        String fileName1 = args[0];
        String pointsFileName = args[1];

        try {
            BufferedReader circleReader = new BufferedReader(new FileReader(fileName1));
            String circleCenterStr = circleReader.readLine();
            float circleCenterX = Float.parseFloat(circleCenterStr.split(" ")[0]);
            float circleCenterY = Float.parseFloat(circleCenterStr.split(" ")[1]);
            float circleRadius = Float.parseFloat(circleReader.readLine());
            circleReader.close();

            BufferedReader pointsReader = new BufferedReader(new FileReader(pointsFileName));
            String pointStr;
            while ((pointStr = pointsReader.readLine()) != null) {
                float pointX = Float.parseFloat(pointStr.split(" ")[0]);
                float pointY = Float.parseFloat(pointStr.split(" ")[1]);

                int position = getPointPosition(circleCenterX, circleCenterY, circleRadius, pointX, pointY);
                System.out.print(position + " ");
            }
            System.out.println();
            pointsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getPointPosition(float centerX, float centerY, float radius, float pointX, float pointY) {
        float distanceSquared = (pointX - centerX) * (pointX - centerX) + (pointY - centerY) * (pointY - centerY);

        if (Math.abs(distanceSquared - radius * radius) < 1e-9) {
            return 0;
        } else if (distanceSquared < radius * radius) {
            return 1;
        } else {
            return 2;
        }
    }
}

