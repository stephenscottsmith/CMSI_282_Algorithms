import java.util.Arrays;
import java.util.ArrayList;

public class Permutation extends java.lang.Object {

	public int [] perm;
	public int [] lastPerm;
	public long permCount;
	
	public Permutation (int n) {
		if (n < 1) {
			throw new IllegalArgumentException("INVALID INTEGER FOR A PERMUTATION OBJECT!");
		} else {
			this.perm = new int[n];
			// fill array
			for (int i = 0; i < n; i++) {
				this.perm[i] = i;
			}

			this.lastPerm = determineLastPerm(this.perm);

			this.permCount = 1;
		}  
	}

	public Permutation (int [] n) {
		if (isValid(n)) {
			this.perm = n;
			this.lastPerm = determineLastPerm(this.perm);
			this.permCount = 1;
		} else {
			throw new IllegalArgumentException("INVALID ARRAY FOR A PERMUTATION OBJECT!");
		}
	}

	/* HELPER FUNCTIONS */

	private int [] determineLastPerm (int [] perm) {
		int [] lastPerm = new int[perm.length];

		for (int i = (perm.length - 1), j = 0; i >= 0; i--, j++) {
			lastPerm[j] = perm[i];
		}
		return lastPerm;
	}

	// Determines index of next largest
	private int getIndexOfNextLargest (int nextLargest) {
		for (int i = 0; i < this.perm.length; i++) {
			if (this.perm[i] == nextLargest) {
				return i;
			}
		}
		return -1;
	}

	// Determines next largest, determines index of it, and returns the index
	private int nextLargestNumberInArrayIndex (int first, int second) {
		int nextLargest = this.perm[second];


		for (int i = (second); i < this.perm.length; i++) {
			if (this.perm[i] < nextLargest && this.perm[i] > this.perm[first]) {
				nextLargest = this.perm[i];
			}
		}
		//System.out.println("nextLargest: " + nextLargest);
		return getIndexOfNextLargest(nextLargest);
	}

	private int generateRandomNumber (int min, int max) {
		return min + (int)(Math.random() * (max - min));
	}

	private void shufflePermArray () {
		int length = this.perm.length;
		for (int i = 0; i < length; i++) {
			int random = generateRandomNumber(i, length);
			int replacement = this.perm[i];
			this.perm[i] = this.perm[random];
			this.perm[random] = replacement;
		}
	}
	/* END HELPER FUNCTION */

	public void advance () {
		int first = (this.perm.length - 2), 
			second = (this.perm.length - 1);
		boolean advanced = false;


		while (!advanced) {
			if (this.perm[first] < this.perm[second]) {
				// swap the first w/ the next biggest number
				int indexOfNextLargest = nextLargestNumberInArrayIndex(first, second);
				int oldFirst = this.perm[first];
				this.perm[first] = this.perm[indexOfNextLargest];
				this.perm[indexOfNextLargest] = oldFirst;
				
				// sort the array from the index of the second number to the end
				Arrays.sort(this.perm, second, (this.perm.length));
				advanced = true;

			} else {
				first--;
				second--;

				if (first < 0) {
					throw new IllegalArgumentException("CANNOT ADVANCE ANY FURTHER");
				}
			}
		}	
	}

	public int getElement (int i) {
		return this.perm[i];
	}

	public boolean isFirstPerm() {
		int [] lexicographicalFirst = Arrays.copyOf(this.perm, this.perm.length);
		Arrays.sort(lexicographicalFirst);

		return Arrays.equals(this.perm, lexicographicalFirst);
	}

	public boolean isLastPerm () {
		return Arrays.equals(this.perm, this.lastPerm);
	}

	public static boolean isValid (int [] perm) {
		ArrayList<Integer> permNumberCount = new ArrayList<Integer>(); 
		for (int i = 0; i < perm.length; i++) {
			if (permNumberCount.contains(perm[i])) {
				return false;
			} else {
				permNumberCount.add(perm[i]);
			}
		}
		return true;
	}

	static Permutation randomPermutation (int n) {
		Permutation p1 = new Permutation(n);
		p1.shufflePermArray();
		return p1;
	}

	public void reset () {
		Arrays.sort(this.perm);
	}

	public int [] toArray() {
		return this.perm;
	}

	public String toString() {
		String permString = "";

		for (int i = 0; i < this.perm.length; i++) {
			permString += Integer.toString(this.perm[i]) + " ";
		}

		return permString;
	}

	// Only need to calculate n! because (n - r)!
	// in n!/(n - r)! will always equal 1
	public static long totalPermutations (int n) {
		return n * ((n > 1) ? totalPermutations(n - 1) : 1);
	}




}

