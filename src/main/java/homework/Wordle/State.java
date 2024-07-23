package homework.Wordle;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.Objects;

import static homework.Wordle.Wordle.*;

public class State {
    Color[] word_state;                 // The guess state of word
    Color[] alphabet_state;             // The guess state of the alphabet
    int chance_left;                    // The chances left
    String answer, word;                // The final answer, and the current guess word
    GameStatus status;                  // The current game status

    public State(String answer) {
        word_state = new Color[WORD_LENGTH];
        Arrays.fill(word_state, Color.GRAY);
        alphabet_state = new Color[ALPHABET_SIZE];
        Arrays.fill(alphabet_state, Color.GRAY);
        chance_left = TOTAL_CHANCES;
        this.answer = answer;
        word = "";
        status = GameStatus.RUNNING;
    }
    public State(JSONObject json) {
        this.word_state = new Color[WORD_LENGTH];
        String word_state_string = json.getString("word_state");
        for (int i = 0; i < WORD_LENGTH; i++) {
            this.word_state[i] = Color.getColorByChar(word_state_string.charAt(i));
        }
        this.alphabet_state = new Color[ALPHABET_SIZE];
        String alphabet_state_string = json.getString("alphabet_state");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            this.alphabet_state[i] = Color.getColorByChar(alphabet_state_string.charAt(i));
        }
        this.chance_left = json.getInt("chance_left");
        this.answer = json.getString("answer").toUpperCase();
        this.word = json.getString("word").toUpperCase();
        this.status = GameStatus.valueOf(json.getString("status"));
    }
    @Override
    public String toString() {
        return Arrays.toString(word_state) + "$" + Arrays.toString(alphabet_state) + "$"
                + chance_left + "$" + answer + "$" + word + "$" + status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(this.toString(), o.toString());
    }
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(word_state),
                Arrays.hashCode(alphabet_state), chance_left, answer, word, status);
    }
    // Use colorful display
    public static void printColored(char text, Color color) {
        switch (color) {
            case GRAY -> System.out.print("\033[37m" + text + "\033[0m");
            case RED -> System.out.print("\033[31m" + text + "\033[0m");
            case YELLOW -> System.out.print("\033[33m" + text + "\033[0m");
            case GREEN -> System.out.print("\033[32m" + text + "\033[0m");
        }
    }
    // Output the current game state
    public void show() {
        for (int i = 0; i < WORD_LENGTH; i++) {
            printColored(word.charAt(i), word_state[i]);
        }
        System.out.print(" ");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            printColored((char)('A' + i), alphabet_state[i]);
        }
        System.out.println();
    }
}
