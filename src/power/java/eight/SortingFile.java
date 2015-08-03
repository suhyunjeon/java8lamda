package power.java.eight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author tasha.jeon
 * @since 2015. 8. 1
 */
public class SortingFile {

    public static void main(String args[]) {

        readFileOldVersion();
        readFileNewVersion();

    }

    public static void readFileOldVersion() {

        try {
            FileReader fileReader = new FileReader(new File("/Users/suhyunjeon/tmp/obama_2009.txt"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<String> uniqueWords = new ArrayList<String>();
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] words = line.split("[\\s]+");
                for (String word : words) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
            Collections.sort(uniqueWords);
            System.out.println(uniqueWords);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileNewVersion() {
        // 모나드
        try {
            final Stream<String> lines = Files.lines(Paths.get("/Users/suhyunjeon/tmp/obama_2009.txt"));
            System.out.println(lines
                    .map(line -> line.split("[\\s]+"))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .sorted()
                    .collect(toList())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
