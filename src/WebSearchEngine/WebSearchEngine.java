package WebSearchEngine;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebSearchEngine {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		String pathHTML = "D:\\Studies\\MAC\\ACC\\PRACTICAL\\ACC Workspace\\ACC PROJECT\\files\\";
		String pathTEXT = "D:\\Studies\\MAC\\ACC\\PRACTICAL\\ACC Workspace\\ACC PROJECT\\Text\\";
		/** HTML to TEXT Conversion **/
		HTMLtoText.convert(pathHTML, pathTEXT);
		
		
		Scanner sc = new Scanner(System.in);
		String search;
		
		Set<String> suggestedWords;
		String option;
		while(true) {
			System.out.println("Enter String to Search :: ");
			search = sc.next();
			search = search.toLowerCase();
			
			suggestedWords = EditDistance.suggestedWords(pathTEXT, search);
			for(String s:suggestedWords) {
				search = s;
				System.out.println(s);
			}
			if(suggestedWords.size() == 0)
			{
				break;
			}
			else {
				System.out.println("Did you mean ?(Y/N) ");
				option = sc.next().toLowerCase();
				if(option.equals("y"))
				{
					break;
				}
				else
				{
					continue;
				}
				
			}
		}
			
		
		//Set<String> suggestedWords = EditDistance.suggestedWords(pathTEXT, search);
		
		/** Brute Force to find Occurrence with Offset and Sorting**/
		
		BruteForce.BruteForceHandle(pathTEXT,search);
		
		
		/** Find URLS **/
		System.out.println("Would you like to find links ? (Y/N)");
		String reply = sc.next().toLowerCase();
		if(reply.equals("y"))
			Regex.urlFinder(pathTEXT);
		else
			System.out.println("BYE !");
		sc.close();
	}
}
