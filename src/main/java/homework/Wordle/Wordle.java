package homework.Wordle;

import java.util.*;

public class Wordle {
    static final int ALPHABET_SIZE = 26;            // The size of the alphabet
    static final int WORD_LENGTH = 5;               // The length of words
    static final int TOTAL_CHANCES = 6;             // The chances in total

    // Guess `word` at state `s`
    public static State guess(State s) {
        Arrays.fill(s.word_state, Color.GRAY);
        int[] guessAlphabetCount = new int[ALPHABET_SIZE];
        int[] answerAlphabetCount = new int[ALPHABET_SIZE];

        for (int i = 0; i < WORD_LENGTH; i++) {
            int answer_index = s.answer.charAt(i) - 'A';
            answerAlphabetCount[answer_index]++;
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            if (s.word.charAt(i) == s.answer.charAt(i)) {
                int word_index = s.word.charAt(i) - 'A';
                guessAlphabetCount[word_index]++;
            }
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            int word_index = s.word.charAt(i) - 'A';
            if (s.word.charAt(i) == s.answer.charAt(i)) {
                s.word_state[i] = Color.GREEN;
                s.alphabet_state[word_index] = Color.GREEN;
            } else {
                if (s.answer.contains(String.valueOf(s.word.charAt(i)))
                        && guessAlphabetCount[word_index] < answerAlphabetCount[word_index]) {
                    s.word_state[i] = Color.YELLOW;
                } else {
                    s.word_state[i] = Color.RED;
                }
                if (s.alphabet_state[word_index] == Color.GRAY || s.alphabet_state[word_index] == Color.RED) {
                    if (s.answer.contains(String.valueOf(s.word.charAt(i)))) {
                        s.alphabet_state[word_index] = Color.YELLOW;
                    } else {
                        s.alphabet_state[word_index] = Color.RED;
                    }
                }
                guessAlphabetCount[word_index]++;
            }
        }

        if (Objects.equals(s.word, s.answer)) {
            s.status = GameStatus.WON;
        } else {
            if (s.chance_left == 1) {
                s.status = GameStatus.LOST;
            }
            s.chance_left--;
        }
        return s;
    }
    public static void main(String[] args) {
        WordSet wordSet = new WordSet("assets/wordle/FINAL.txt", "assets/wordle/ACC.txt");

        Scanner input = new Scanner(System.in);
        String answer;
        do {
            System.out.print("Enter answer: ");
            answer = input.nextLine().toUpperCase().trim();
            if (wordSet.isNotFinalWord(answer)) {
                System.out.println("INVALID ANSWER");
            }
        } while (wordSet.isNotFinalWord(answer));

        State state = new State(answer);
        while (state.status == GameStatus.RUNNING) {
            String word;
            do {
                System.out.print("Enter word guess: ");
                word = input.nextLine().toUpperCase().trim();
                if (wordSet.isNotAccWord(word)) {
                    System.out.println("INVALID WORD GUESS");
                }
            } while (wordSet.isNotAccWord(word));
            state.word = word;
            state = guess(state);
            state.show();
        }
        if (state.status == GameStatus.LOST) {
            System.out.println("You lost! The correct answer is " + state.answer + ".");
        } else {
            System.out.println("You won! You only used " + (TOTAL_CHANCES - state.chance_left) + " chances.");
        }
    }
}
