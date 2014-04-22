public class Player {
	private int numberOfDice;
	private int sidesOfDice;
	private int[]dice;
	private int possibleSumsLength;
	private int[][] possibleSums; // value x number of times that value can be rolled

	public Player (int numberOfDice, int sidesOfDice) {
		this.numberOfDice = numberOfDice;
		this.sidesOfDice = sidesOfDice;
		this.dice = new int[numberOfDice];
		
		// int quantityLength = 1;
		// this.possibleSumsLength = (numberOfDice * sidesOfDice) + sidesOfDice;
		// this.possibleSums = new int[this.possibleSumsLength][quantityLength];
	}

	public int rollAndGetSum () {
		int sum = 0;
		for (int j = 0; j < this.dice.length; j++) {
			this.dice[j] = (int)Math.floor(Math.random() * this.sidesOfDice) + 1;
			sum += this.dice[j];
		}
		return sum;
	}

	// public boolean setDice (int value) {
	// 	if (value >= 1) {
	// 		for (int i = 0; i < this.dice.length; i++) {
	// 			this.dice[i] = value;
	// 		}
	// 		return true;
	// 	}
	// 	return false;		
	// }

	// public int[] getDice () {
	// 	return this.dice;
	// }

	// public int getSumOfDice () {
	// 	int sum = 0;
	// 	for (int k = 0; k < this.dice.length; k++) {
	// 		sum += this.dice[k];
	// 	}
	// 	return sum;
	// }

	// public void incrementDice (int dieIndex, int increment) {
	// 	this.dice[dieIndex] += increment;
	// }

	// public boolean determinePossibleSums () {
	// 	for (int i = 0; i < this.dice.length; i++) {
	// 		for (int j = 1; j <= this.sidesOfDice; j++) {
	// 			int sum = this.getSumOfDice();
	// 			this.placeSum(sum);				

	// 		}
	// 	}
	// }
}