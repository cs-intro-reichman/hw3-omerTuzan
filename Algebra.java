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
   		System.out.println(div(12,3));   // 12 / 3    
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
			// handles negative additive numbers in +
			for (int i = x2; i < 0; i++){
				Sum--;
			}
		} else {
			// handles ragular positive numbers in + 
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
			// handles negative subtracted numbers in -
			for (int i = x2; i < 0; i++){
				Sub++;
			}
		} else {
			// handles positive subtracted numbers in -
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
			// handles negative multiplication numbers in *
			for (int i = x2; i < 0 ; i++){
				mul = minus(mul, x1);
			}

		} else {
			// handles positive multiplication numbers in *
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
		if (x2 == 0) {
			throw new ArithmeticException("Cant devide by zero");
		}

		int divide = x1;
		int amountDiv = 0;

		if (x1 < 0) {
			// handles dividing x1 if it is negative
			while (divide < 0){
				amountDiv++;
				// handles the division calculation diffrently if x2 is negitive or positive
				if (x2 < 0){
					divide = minus(divide, x2);
				} else {
					divide = plus(divide, x2);
				}
				if (divide > 0) {return 0;}
			}
		} else {
			// handles dividing x1 if it is positive
			while (divide > 0){
				amountDiv++;
				// handles the division calculation diffrently if x2 is negitive or positive
				if (x2 < 0){
					divide = plus(divide, x2);
				} else {
					divide = minus(divide, x2);
				}
			}
			if (divide < 0) {return 0;}
		}
		
		// handles the amount of negative operators, since amountDiv is a counter and always positive, these steps will fix its type(negative|positive)
		if (x1 < 0) {amountDiv = times(amountDiv, -1);}
		if (x2 < 0) {amountDiv = times(amountDiv, -1);}

		// Replace the following statement with your code
		return amountDiv;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int module = x1;

		// if a number is devided correctly it will return a number that is not 0, meaning it can be devided by x2
		if (div(x1, x2) != 0) return 0;

		// it just works :)))))))))))))
		while (module > x2){
			module = minus(module, x2);
		}

		return module;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		for (int i = 1; i <= x; i++){
			// not much to tell since x = s^2 than if we power by 2 all the numbers from 1 to s, lets call them i, by some point x will be lower than i^2, therefore the closest number was the one before
			if (pow(i, 2) > x){
				return i - 1;
			}

		}
		return x;
	}	  	  
}