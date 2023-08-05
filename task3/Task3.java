package task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Task3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Incorrect args. Usage: java Task3 tests.json values.json");
            return;
        }

        String testsFile = args[0];
        String valuesFile = args[1];

        try {
            JSONParser parser = new JSONParser();
            JSONObject testsObject = (JSONObject) parser.parse(new FileReader(testsFile));
            JSONArray testsArray = (JSONArray) testsObject.get("tests");

            JSONObject valuesObject = (JSONObject) parser.parse(new FileReader(valuesFile));
            JSONArray valuesArray = (JSONArray) valuesObject.get("values");

            processTests(testsArray, valuesArray);

            JSONObject reportObject = new JSONObject(); //Создание репорт файла
            reportObject.put("tests", testsArray);

            FileWriter reportWriter = new FileWriter("report.json"); // Заполняем данными
            reportWriter.write(reportObject.toJSONString());
            reportWriter.close(); // Закрывваем поток записи данных

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод processTests
    // Этот метод рекурсивно обрабатывает массив testsArray
    // Для каждого теста в массиве мы ищем соответствующее значение
    // в массиве valuesArray по полю "id". Когда находим, мы берем значение "value" из valuesArray
    // и записываем его в поле "value" теста в testsArray.
    // Таким образом, каждый тест получит свое соответствующее значение из values.json.
    private static void processTests(JSONArray testsArray, JSONArray valuesArray) {
        for (Object test : testsArray) {
            JSONObject testObject = (JSONObject) test;
            Long testId = (Long) testObject.get("id");

            for (Object value : valuesArray) {
                JSONObject valueObject = (JSONObject) value;
                Long valueId = (Long) valueObject.get("id");

                if (testId.equals(valueId)) {
                    String result = (String) valueObject.get("value");
                    testObject.put("value", result);
                    break;
                }
            }

            JSONArray nestedTestsArray = (JSONArray) testObject.get("values");
            if (nestedTestsArray != null) {
                processTests(nestedTestsArray, valuesArray);
            }
        }
    }
}

