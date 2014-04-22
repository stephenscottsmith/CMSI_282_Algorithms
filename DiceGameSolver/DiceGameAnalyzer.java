public class DiceGameAnalyzer {
	public static void main(String[] args) {
		// Player a = new Player(6, 6);
		// Player b = new Player(9, 4);
		// a.setDice(1);
		// b.setDice(1);
		// System.out.println(a.setDice(1));
		// System.out.println(b.setDice(1));

		int[] a = {1, 1, 1, 1, 1, 1};
		int[] b = {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[][] sumsA = new int[37][1];
		int[][] sumsB = new int[37][1];
		
		// fill sumsA table
		for (int i = 0; i < 6; i++) {
			System.out.println("");
			for (int j = 0; j < 6; j++) {
				a[i] += 1;
				System.out.println("0: " + a[i]);
				System.out.println("1: " + a[i + 1]);
				if (a[i] > 6) {
					a[i] = 1;
					a[i + 1] += 1;
				} 
				// Calc Sum
				int sum = 0;
				for (int k = 0; k < a.length; k++) {
					sum += a[k];
				}
				// Place Sum by incrementing spot in array
				sumsA[sum][0] += 1;
				// spot in array goes above 6, set it equal to 1, and increment the next index

				// if the next index does not exist, break
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		// // fill sumsB table
		// for (int i = 1; i <= 6; i++) {
		// 	for (int j = 1; i <= 6; i++) {

		// 	}
		// // }

	}
}