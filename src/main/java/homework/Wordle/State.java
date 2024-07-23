package homework.Wordle;

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
    public State(Color[] word_state, Color[] alphabet_state, int chance_left, String answer, String word, GameStatus status) {
        this.word_state = word_state;
        this.alphabet_state = alphabet_state;
        this.chance_left = chance_left;
        this.answer = answer;
        this.word = word;
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        if (!Arrays.equals(word_state, state.word_state)) return false;
        if (!Arrays.equals(alphabet_state, state.alphabet_state)) return false;
        if (chance_left != state.chance_left) return false;
        if (!Objects.equals(answer, state.answer)) return false;
        if (!Objects.equals(word, state.word)) return false;
        return status == state.status;
    }
    @Override
    public int hashCode() {
        int result = Arrays.hashCode(word_state);
        result = 31 * result + Arrays.hashCode(alphabet_state);
        result = 31 * result + chance_left;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
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
