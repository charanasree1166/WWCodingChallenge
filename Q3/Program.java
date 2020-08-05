package Q3;

import java.util.*;

   public class Program
   {
	  static void main(String[] args)
	  {
		 System.out.println("How many random numbers you want generate?: ");

		 String val = new Scanner(System.in).nextLine();

		 // convert to integer
		 int n = Integer.parseInt(val);

		 java.util.ArrayList<Integer> randomNumbers = GetRandoms(n);
		 PrintRandomNumbers(randomNumbers);
		 randomNumbers = SortRandoms(randomNumbers);
		 System.out.println("Input n Value: ");
		 val = new Scanner(System.in).nextLine();

		 // convert to integer
		 n = Integer.parseInt(val);

		 System.out.println("nth smallest value in random list is : " + randomNumbers.get(n - 1));
		 new Scanner(System.in).nextLine();

	  }

	  /** 
	   Prints all generated random numbers
	   
	   @param randomNumbers
	  */
	  private static void PrintRandomNumbers(java.util.ArrayList<Integer> randomNumbers)
	  {
		 System.out.println("generated Random numbers are ");

		 for (int n : randomNumbers)
		 {
			System.out.print(n + " ");
		 }
		 System.out.println("");
	  }

	  /** 
	   Sorts the generated random numbers
	   
	   @param randomNumbers
	   @return 
	  */
	  private static java.util.ArrayList<Integer> SortRandoms(java.util.ArrayList<Integer> randomNumbers)
	  {
		 java.util.Collections.sort(randomNumbers);
		 return randomNumbers;
	  }

	  /** 
	   Generates Random numbers
	   
	   @param count
	   @return 
	  */
	  private static java.util.ArrayList<Integer> GetRandoms(int count)
	  {
		 java.util.Random random = new java.util.Random();
		 java.util.ArrayList<Integer> result = new java.util.ArrayList<Integer>(count);
		 for (int i = 0; i < count; i++)
		 {

			result.add(random.nextInt());
		 }
		 return result;
	  }
   }