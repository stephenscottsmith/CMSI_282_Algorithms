test.java

		// tests to confirm calculating chances works
		int [] test1 = {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] test2 = {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] test3 = {1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] test4 = {1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] test5 = {1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] test6 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
		int [] test7 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 20};
		int [] test8 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 11, 6};
		int [] test9 = {-1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

		// answers 
		1: 1 0 0 0 0 0 0 0 0 0 0 true
		2: 2 0 0 0 0 0 0 0 0 0 0 false
		3: 1 1 0 0 0 0 0 0 0 0 0 true
		4: 2 2 0 0 0 0 0 0 0 0 0 false
		5: 1 2 1 0 0 0 0 0 0 0 0 true
		6: 1 2 3 4 5 6 5 4 3 2 1 true
		7: 1 2 3 4 5 5 4 3 2 1 0 true
		8: 1 2 3 4 5 5 4 3 2 1 1 true
		9: 0 0 0 0 0 0 0 0 0 0 0 true

		// code
		int [][]testChances = {
			test1, test2, test3, test4, test5, test6, test7, test8, test9
		}; 

		for (int i = 0; i < testChances.length; i++) {
			int [] chances = generateGuessChances(testChances[i]);
			for (int j = 0; j < chances.length; j++) {
				if (j == 0) {
					System.out.print((i + 1) + ": ");
				}
				System.out.print(chances[j] + " ");
			}
			System.out.println(hasValidChances(chances));
		}