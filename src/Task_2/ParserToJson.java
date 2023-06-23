package Task_2;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;


public class ParserToJson {
    private File inputFile = new File("personFile.txt");
    private File outputFile = new File("user.json");
    private ArrayList<Person> users = new ArrayList<>();


    public void readFile() {
        try (FileReader reader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            boolean isFirstLine = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] information = line.split("\\s+");
                String name = information[0];
                int age = Integer.parseInt(information[1]);

                Person person = new Person(name, age);
                users.add(person);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
