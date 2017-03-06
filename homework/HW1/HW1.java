import java.util.*;
public class HW1 {
	/* Check whether it's prime number */
	public static boolean isPrime(int num) {
		// Write down your code.
		boolean check = false;
		double my_sqrt = Math.sqrt(num);
		for(int i = 2;i <= my_sqrt;i++)
		{
			if(num % i == 0)
			{
				check = false;
				break;
			}
			else
				check = true;
		}
		if(num == 2 || num == 3)
			check = true;
		return check;
	}

	public static void main(String[] args) {
		int option, num, i, count;
		Scanner scan = new Scanner(System.in);
		boolean isprime = false;
		while (true) {
			try {
				/* Get standard input object. */
				/* Print message. */
				System.out.println("1. Check whether it's prime number\n" + "2. Find prime number(2~N)\n" + "3. Leave");
				/* Input an integer. */
				option = scan.nextInt();
				switch (option) {
				case 1:
					/* Write down your code. */
					/* Check whether it's prime number */
					System.out.println("Input the number:");
					num = scan.nextInt();
					if(num < 2)
					{
						System.out.println("Input error : N must equal greater than 2");
						break;
					}
					isprime = isPrime(num);
					if(isprime)
						System.out.println(num + " is a prime");
					else if(!isprime)
						System.out.println(num + " is not a prime");
					break;
				case 2:
					/* Write down your code. */
					/* Find prime number(2~N) */
					System.out.println("Input the number:");
					count = 0;
					num = scan.nextInt();
					for(i = 2;i <= num;i++)
					{
						if(isPrime(i))
						{
							count = count + 1;
							if(i < 10)
								System.out.print(" "+ i + "   ");
							else if(i >= 10)
								System.out.print(i + "   ");
							if(count % 7 == 0)
								System.out.println();
						}
					}
					System.out.println();
					break;
				case 3:
					/* Write down your code. */
					/* End the process */
					System.out.println("Bye!!");
					System.exit(0);
					break;
				default:
					System.out.println("Input error : incorrect option");
					break;
				}
			} catch (InputMismatchException e) {
					System.out.println("Input error : ONLY Integers.");
			}
		}
	}

}
