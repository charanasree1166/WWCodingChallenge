package Q1;

import java.util.*;

   public class Program
   {
	  static void main(String[] args)
	  {
		 String file = ".//..//..//..//Dict.txt";
		 if (DoesFileExist(file))
		 {
			System.out.println("File Present at location" + file);
			PrintDict(file);
			new Scanner(System.in).nextLine();
		 }
		 else
		 {
			System.out.println("File Not Present at location" + file);
		 }
	  }

	  /** 
	   To print the Dictionary words and meanings
	   
	   @param file user file name
	  */
	  private static void PrintDict(String file)
	  {
		 String[] lines = File.ReadAllLines(file, Encoding.UTF8);
		 for (String line : lines)
		 {
			String[] words = line.split("[–]", -1);
			System.out.println(words[0].trim());
			String[] meanings = words[1].split("[,]", -1);
			for (String meaning : meanings)
			{
			   System.out.println(meaning.trim());
			}
		 }
	  }

	  /** 
	   To check the file exist or not
	   
	   @param fileName User file name
	   @return returns true if file exists
	  */
	  private static boolean DoesFileExist(String fileName)
	  {
		 return (new java.io.File(fileName)).isFile();
		 // throw new NotImplementedException();
	  }
   }