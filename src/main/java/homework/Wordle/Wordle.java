package homework.Wordle;

import java.util.*;

public class Wordle {
    static final int ALPHABET_SIZE = 26;            // The size of the alphabet
    static final int WORD_LENGTH = 5;               // The length of words
    static final int TOTAL_CHANCES = 6;             // The chances in total

    // Guess `word` at state `s`
    public static State guess(State s) {
        // TODO begin
        Arrays.fill(s.wordState, Color.GRAY);
        int[] guessAlphabetCount = new int[ALPHABET_SIZE];
        int[] answerAlphabetCount = new int[ALPHABET_SIZE];

        for (int i = 0; i < WORD_LENGTH; i++) {
            int answerIndex = s.answer.charAt(i) - 'A';
            answerAlphabetCount[answerIndex]++;
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            if (s.word.charAt(i) == s.answer.charAt(i)) {
                int wordIndex = s.word.charAt(i) - 'A';
                guessAlphabetCount[wordIndex]++;
            }
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            int wordIndex = s.word.charAt(i) - 'A';
            if (s.word.charAt(i) == s.answer.charAt(i)) {
                s.wordState[i] = Color.GREEN;
                s.alphabetState[wordIndex] = Color.GREEN;
            } else {
                if (s.answer.contains(String.valueOf(s.word.charAt(i)))
                        && guessAlphabetCount[wordIndex] < answerAlphabetCount[wordIndex]) {
                    s.wordState[i] = Color.YELLOW;
                } else {
                    s.wordState[i] = Color.RED;
                }
                if (s.alphabetState[wordIndex] == Color.GRAY || s.alphabetState[wordIndex] == Color.RED) {
                    if (s.answer.contains(String.valueOf(s.word.charAt(i)))) {
                        s.alphabetState[wordIndex] = Color.YELLOW;
                    } else {
                        s.alphabetState[wordIndex] = Color.RED;
                    }
                }
                guessAlphabetCount[wordIndex]++;
            }
        }

        if (Objects.equals(s.word, s.answer)) {
            s.status = GameStatus.WON;
        } else if (s.chancesLeft == 1) {
            s.status = GameStatus.LOST;
        }
        s.chancesLeft--;
        // TODO end
        return s;
    }
    public static void main(String[] args) {
        // Read word sets from files
        WordSet wordSet = new WordSet("assets/wordle/FINAL.txt", "assets/wordle/ACC.txt");

        Scanner input = new Scanner(System.in);
        // Keep asking for an answer if invalid
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
            // Keep asking for a word guess if invalid
            String word;
            do {
                System.out.print("Enter word guess: ");
                word = input.nextLine().toUpperCase().trim();
                if (wordSet.isNotAccWord(word)) {
                    System.out.println("INVALID WORD GUESS");
                }
            } while (wordSet.isNotAccWord(word));
            // Try to guess a word
            state.word = word;
            state = guess(state);
            state.show();
        }
        if (state.status == GameStatus.LOST) {
            System.out.println("You lost! The correct answer is " + state.answer + ".");
        } else {
            System.out.println("You won! You only used " + (TOTAL_CHANCES - state.chancesLeft) + " chances.");
        }
    }
}
