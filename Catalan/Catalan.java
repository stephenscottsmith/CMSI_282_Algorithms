import java.math.BigInteger;

public class Catalan {
	
	private static BigInteger[] results;

	public static void main (String[] args) {
		
		int n = Integer.parseInt(args[0]);
		
		results = new BigInteger[n + 1];
		results[0] = BigInteger.ONE;
		results[1] = BigInteger.ONE;
		results[2] = BigInteger.ONE;


		System.out.println(catalan(n));
	}

	public static BigInteger catalan (int n) {
		if (results[n] != null) {
			return results[n];
		} else {
			BigInteger total = BigInteger.ZERO;

			for (int i = 1; i < n; i++) {
				total = total.add(catalan(n - i).multiply(catalan(i)));

			}
			results[n] = total;
			return total;	
		}
	}
}