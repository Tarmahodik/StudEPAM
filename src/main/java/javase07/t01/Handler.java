package javase07.t01;


import javax.naming.InsufficientResourcesException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Handler {
    private final ArrayList<String> listOfFile = new ArrayList<>();

    public Handler(File file) throws InsufficientResourcesException {

        readFromFile(file);

        Map<String, Account> accounts = new HashMap<>();

        for (String s : listOfFile
                ) {
            if (s.contains("-")) {
                String accountArray[] = s.split("-");
                accounts.put(accountArray[0], new Account(accountArray[0], Integer.parseInt(accountArray[1])));
            }
        }

        for (String s : listOfFile) {

            if (s.contains(",")) {
                String[] transfer = s.split(",");
                Operations operations = new Operations();
                operations.start();
                operations.transfer(accounts.get(transfer[0]), accounts.get(transfer[1]), Integer.parseInt(transfer[2]));
            }
        }

    }

    private void readFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String input;
            while ((input = reader.readLine()) != null) {
                listOfFile.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}