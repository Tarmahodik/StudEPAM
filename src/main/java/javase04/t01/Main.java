package javase04.t01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        File file = new Getter().getFile("javase04/t01/Main.java");
        FileInputStream fis = new FileInputStream(file);
        byte[] fileContent = new byte[(int) file.length()];
        fis.read(fileContent);
        String s = new String(fileContent);
        String[] fileContentStringArray = s.split(" ");
        fis.close();

        File fileKeywords = new Getter().getFile("javase04/t01/keywords.txt");
        FileInputStream fisKeywords = new FileInputStream(fileKeywords);
        byte[] keywordsContent = new byte[(int) fileKeywords.length()];
        fisKeywords.read(keywordsContent);
        String[] keywords = new String(keywordsContent).split(",");
        fisKeywords.close();
        Map<String, Integer> keywordsMatching = new HashMap<>();

        for (String keyword : keywords)
        {
            int counter = 0;
            Pattern pattern = Pattern.compile(keyword);
            for (String fileString : fileContentStringArray) {
                Matcher matcher = pattern.matcher(fileString);
                if (matcher.matches()) counter++;
            }
            if (counter == 0) continue;
            keywordsMatching.put(keyword, counter);
        }
        FileOutputStream fos = new FileOutputStream(new File("result.csv"));
        keywordsMatching.forEach((x, y) -> {
            byte[] b = x.getBytes();
            byte[] a = ", ".getBytes();
            byte[] z = "\n".getBytes();
            try {
                fos.write(b);
                fos.write(a);
                fos.write(y.toString().getBytes());
                fos.write(z);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fos.close();
    }
}

