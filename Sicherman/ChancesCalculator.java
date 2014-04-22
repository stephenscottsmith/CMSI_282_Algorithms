import java.util.Arrays;

public class ChancesCalculator {
	public static void main(String[] args) {
		if (args.length > 12) {
			System.out.println("TOO MANY!");
		} else {
			// Parse Input
			int [] dice = new int[12];
			for (int i = 0; i < args.length; i++) {
				dice[i] = Integer.parseInt(args[i]);
			}

			// Send dice to chance generator
			int [] chances = generateChances(dice);

			printSolution(chances);
			System.out.println(isValidPartialSolution(chances));
			System.out.println("Same as canon: " + hasSameDiceAsCanon(dice));
		}

	}

	public static int [] generateChances (int [] currentGuess) {
		int [] currentGuessChances = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int sum = 0;
		// For each even, add it up with each odd
		for (int evenIndex = 0; evenIndex <= 10; evenIndex += 2) {
			for (int oddIndex = 1; oddIndex <= 11; oddIndex += 2) {
				if (currentGuess[evenIndex] == 0 || currentGuess[oddIndex] == 0) {
					continue;
				}
				sum = currentGuess[evenIndex] + currentGuess[oddIndex];
				if (sum >= 2 && sum <= 12) {
					currentGuessChances[(sum - 2)]++;
				}
			}
		}
		return currentGuessChances;
	}

	private static void printSolution (int [] currentGuess) {
		for (int i = 0; i < currentGuess.length; i++) {
			System.out.println((i + 2) + ": " + currentGuess[i]);
		}
	}

	public static Boolean isValidPartialSolution (int [] guessChances) {
		int [] standardDieChances = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};

		for (int i = 0; i < standardDieChances.length; i++) {
			if (guessChances[i] > standardDieChances[i]) {
				return false;
			} 
		} 

		return true;
	}

	public static Boolean hasSameDiceAsCanon (int[] guess) {
		int [] standardDie = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
		return Arrays.equals(standardDie, guess);
	}

}