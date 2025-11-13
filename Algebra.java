// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(30,5));      // 3^5
   		System.out.println(div(12,-4));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int Sum = x1;

		if (x2 < 0) {
			for (int i = x2; i < 0; i++){
				Sum--;
			}
		} else {
			for (int i = 0; i < x2; i++){
				Sum++;
			}

		}

		

		return Sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int Sub = x1;

		if (x2 < 0) {
			for (int i = x2; i < 0; i++){
				Sub++;
			}
		} else {
			for (int i = 0; i < x2; i++){
				Sub--;
			}
	}
		
		

		return Sub;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int mul = 0;
		if (x2 < 0) {
			for (int i = x2; i < 0 ; i++){
				mul = minus(mul, x1);
			}

		} else {
			for (int i = 0; i < x2 ; i++){
				mul = plus(mul, x1);
			}

		}
		

		return mul;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int power = 1;
		for (int i = 0; i < n ; i++){
			power = times(power, x);
		}
		
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divide = x1;
		int amountDiv = 0;
		if (x1 < 0) {
			while (divide < 0){
				amountDiv++;
				if (x2 < 0){
					divide = minus(divide, x2);
				} else {
					divide = plus(divide, x2);
				}
				if (divide > 0) {return 0;}
			}
		} else {
			while (divide > 0){
				amountDiv++;
				if (x2 < 0){
					divide = plus(divide, x2);
				} else {
					divide = minus(divide, x2);
				}
			}
			if (divide < 0) {return 0;}
		}
		
		if (x1 < 0) {amountDiv = times(amountDiv, -1);}
		if (x2 < 0) {amountDiv = times(amountDiv, -1);}

		// Replace the following statement with your code
		return amountDiv;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int module = x1;
		if (div(x1, x2) >= 1) return 0;

		while (module > x2){
			module = minus(module, x2);
		}

		return module;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		for (int i = 0; i <= x; i++){
			if (pow(i, 2) > x){
				return i - 1;
			}
		}
		return 0;
	}	  	  
}