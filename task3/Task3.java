package task3;

import org.json.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Incorrect number of args. Usage: java Task3.java args[0] args[1]");
        }

        String jsonFile = args[0];
        String jsonFile2 = args[1];

        try {
            JSONObject testJson = readFile(jsonFile);
            JSONObject valuesJson = readFile(jsonFile2);
        } catch (JSONException e) {
            System.err.println("Error JSON" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error with stream (read or write)" + e.getMessage());
        }
    }

    public static JSONObject readFile(String fileName) throws JSONException, FileNotFoundException {
        JSONTokener tokener = new JSONTokener(new FileReader(fileName));
        return new JSONObject(tokener);
    }
}
