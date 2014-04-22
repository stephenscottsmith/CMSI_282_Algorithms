public class DiceGameSolver {
	public static void main(String[] args) {
		int simulateTimes = Integer.parseInt(args[0]);
		Player a = new Player(6, 6);
		Player b = new Player(9, 4);
		int aWins = 0;
		int bWins = 0;
		int aSum = 0;
		int bSum = 0;

		for (int i = 0; i < simulateTimes; i++) {
			aSum = a.rollAndGetSum();
			bSum = b.rollAndGetSum();

			if (aSum > bSum) {
				aWins++;
			} else {
				bWins++;
			}
		}
		double aWinPercentage = ((double)aWins / (double)simulateTimes) * 100;
		System.out.println("A wins: " + aWinPercentage);
		
	}
}
