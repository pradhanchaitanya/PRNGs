import java.util.Scanner;

public class MiddleSquare 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int seed;
		System.out.println("Enter a seed: ");
		seed = sc.nextInt();
		
		System.out.println("\nRandom numbers: ");
		
		int cnt = 0;
		int result = extractMid((int) Math.pow(seed, 2));
		while (cnt < 10) {
		    System.out.println(result);
		    int res = extractMid((int) Math.pow(result, 2));
		    result = res;
		    cnt++;
		}
	}
	
	public static int extractMid(int num) {
	    int midFour = 0;
	    int[] midDigits = new int[4];
	    
	    int[] digits = new int[count(num)];
	    for (int i = count(num) - 1; i >= 0; i--) {
	       digits[i] = num % 10;
	       num /= 10;
	    }
	    
	   // for (int i = 0; i < digits.length; i++)
	   //     System.out.print(digits[i]);
	    
	   // System.out.print("\nLength: " + digits.length + "\n");
	    int mid = digits.length / 2;
	    
	    for (int i = (mid - 2), j = 0; i < (mid + 2) && j < 4; i++, j++) {
	        midDigits[j] = digits[i];
	    }
	    
	    for (int j = 3; j >= 0; j--) {
	        midFour += midDigits[j] * Math.pow(10, 3 - j);    
	    }
	    
	    return midFour;
	}
	
	public static int count(int num) {
	    int count = 0;
	    
	    while (num > 0) {
	        num /= 10;
	        ++count;
	    }
	    return count;
	}
}