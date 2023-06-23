package Task_1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumberParser {
    private File file = new File("C:\\Users\\...\\Desktop\\file.txt");
    private ArrayList<String> numbers = new ArrayList<>();

    public void validNumbers() {
        ArrayList<String> validPhoneNumbers = new ArrayList<>();

        readFile();

        String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);

        for (String str : numbers) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                validPhoneNumbers.add(str);
            }
        }

        for (String phoneNumber : validPhoneNumbers) {
            System.out.println(phoneNumber);
        }
    }

    private void readFile() {
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                    numbers.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}