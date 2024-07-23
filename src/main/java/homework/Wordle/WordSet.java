package homework.Wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordSet {
    private static Set<String> final_set = new HashSet<>();           // Words that are allowed to be guessed
    private static Set<String> acc_set = new HashSet<>();             // Words that are allowed to be answers

    public WordSet(String final_set_path, String acc_set_path) {
        final_set = retrieve_set_from_file(final_set_path);
        acc_set = retrieve_set_from_file(acc_set_path);
    }
    private Set<String> retrieve_set_from_file(String path) {
        Set<String> set = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toUpperCase().trim();
                set.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + path);
            e.printStackTrace();
        }
        return set;
    }
    public boolean isNotFinalWord(String word) {
        return !final_set.contains(word);
    }
    public boolean isNotAccWord(String word) {
        return !acc_set.contains(word);
    }
}
