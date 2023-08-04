package task3;

import org.json.*;

public class Task3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Incorrect number of args. Usage: java Task3.java args[0] args[1]");
        }

        String jsonFile = args[0];
        String jsonFile2 = args[1];
    }
}
