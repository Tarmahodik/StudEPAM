package javase04.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(new Getter().getFile("javase04/t01/Main.java"));
        FileReader frKeywords = new FileReader(new Getter().getFile("javase04/t01/keywords.txt"));

        BufferedReader br = new BufferedReader(fr);
        BufferedReader brKeywords = new BufferedReader(frKeywords);


        StringBuilder input = new StringBuilder();
        StringBuilder inputKeywords = new StringBuilder();

        while (br.ready())
        {
            input.append(br.readLine());
        }
        br.close();

        while (brKeywords.ready())
        {
            inputKeywords.append(brKeywords.readLine());
        }
        brKeywords.close();
        String[] fileContentStringArray = input.toString().split(" ");
        String[] keywords = inputKeywords.toString().split(",");

        Map<String, Integer> keywordsMatching = new HashMap<>();

        for (String keyword : keywords) {
            int counter = 0;
            Pattern pattern = Pattern.compile(keyword);
            for (String fileString : fileContentStringArray) {
                Matcher matcher = pattern.matcher(fileString);
                if (matcher.matches()) counter++;
            }
            if (counter == 0) continue;
            keywordsMatching.put(keyword, counter);
        }

        FileWriter fw = new FileWriter(new File("result.csv"));
        BufferedWriter bw = new BufferedWriter(fw);
        keywordsMatching.forEach((x,y) -> {
            try {
                bw.write(x + ", " + y + "\n");
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
    }
}

